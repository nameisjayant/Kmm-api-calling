import SwiftUI
import shared

struct ContentView: View {
    @LazyKoin private var apiService:ApiService
    @LazyKoin private var postRepository:PostRepository
    
	let greet = Greeting().greet()

	var body: some View {
		Text(greet)
	}
    
    mutating func getPost() async -> Void{
        do{
            try await postRepository.getPosts()
        } catch{
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
