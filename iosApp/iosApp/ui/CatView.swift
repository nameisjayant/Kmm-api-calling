//
//  CatView.swift
//  iosApp
//
//  Created by jayant kumar on 25/02/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CatView: View {
    
    @ObservedObject var viewModel:CatViewModel
    
    var body: some View {
        ScrollView(showsIndicators: false){
            
            if case .loading = viewModel.catState {
                ZStack(alignment: .center){
                    ActivityIndicator()
                        .frame(width: 50, height: 50)
                        .foregroundColor(.orange)
                }.frame(maxWidth: .infinity,maxHeight: .infinity,alignment: .center)
            } else if case .success(let data) = viewModel.catState{
                VStack(alignment : .leading){
                    ForEach(data, id: \.id) { data in
                        HStack{

                            if #available(iOS 15.0, *) {
                                AsyncImage(url: URL(string: data.url ?? ""))
                                    .frame(width: 100,height: 100)
                                    .cornerRadius(50)
                            } else {
                                // Fallback on earlier versions
                                Text("No Image")
                            }
                        
                            VStack(alignment : .leading){
                                Text("Width : \(data.width ?? 0)")
                                    .foregroundColor(.black)
                                    .font(.title2)
                                Text("Height : \(data.height ?? 0)")
                                    .foregroundColor(.gray)
                                    .font(.title2)
                                    .padding(.top,5)
                            }
                            Spacer()
                        }.frame(alignment: Alignment.leading)
                        .padding(10)
                    }
                }
            } else if case .error(_) = viewModel.catState{
                Text("error")
            }
        }
    }
}

struct CatView_Previews: PreviewProvider {
    static var previews: some View {
        CatView(viewModel: CatViewModel())
    }
}
