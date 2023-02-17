//
//  PostViewModel.swift
//  iosApp
//
//  Created by jayant kumar on 16/02/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import Combine
import KMPNativeCoroutinesAsync

@MainActor
class PostViewModel : ObservableObject{
    
    @Published var postState: ViewState<[Post]> = .initiate
    @LazyKoin private var postRepository:PostRepository
    
    private var cancellables = Set<AnyCancellable>()
    
    init() {
        fetchPosts()
    }
    
    
    func fetchPosts(){
        Task{
            postState = .loading
            do{
               // let nativeFlow = try await asyncFunction(for: postRepository.getPostForIos())
//                let stream = asyncStream(for: [Post(id: 1, body: "Hey")])
//
//                for try await data in stream {
//                    postState = .success(data: data)
//                }
                let posts = try await postRepository.getPostTest()
                postState = .success(data: posts)

            }catch {
                postState = .error(error: error)
            }
        }
      
    }
    
}
