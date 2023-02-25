//
//  CatViewModel.swift
//  iosApp
//
//  Created by jayant kumar on 25/02/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import Combine
import KMPNativeCoroutinesAsync


class CatViewModel : ObservableObject{
    
    @Published var catState:ViewState<[Cat]> = .initiate
    @LazyKoin private var repository:CatRepository
    
    
    init() {
        fecthCat()
    }
    
    
    func fecthCat(){
        Task{
            catState = .loading
            do{
                let nativeFlow = try await asyncFunction(for: repository.getCatsNative())
                let stream = asyncStream(for:nativeFlow)

                for try await data in stream {
                    catState = .success(data: data)
                }
//                let posts = try await postRepository.getPostTest()
//                postState = .success(data: posts)

            }catch {
                catState = .error(error: error)
            }
        }
      
    }
    
}
