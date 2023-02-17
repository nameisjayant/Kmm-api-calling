//
//  ViewState.swift
//  iosApp
//
//  Created by jayant kumar on 17/02/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

enum ViewState<T>: Equatable {
  static func == (lhs: ViewState<T>, rhs: ViewState<T>) -> Bool {
    return true
  }

  case initiate
  case loading
  case empty
  case error(error: Error)
  case success(data: T)

  var value: T? {
    if case .success(let data) = self {
      return data
    }
    return nil
  }
}
