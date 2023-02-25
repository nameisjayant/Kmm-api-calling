import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
      KoinApplication.start()
    }
    
    @StateObject var viewModel:PostViewModel = PostViewModel()
    @StateObject var catViewModel : CatViewModel = CatViewModel()
    
	var body: some Scene {
		WindowGroup {
           // ContentView(viewModel: viewModel)
            CatView(viewModel: catViewModel)
		}
	}
}
