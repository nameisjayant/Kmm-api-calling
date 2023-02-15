import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()
    let name = Greeting().getName()
    let test = Greeting().test

	var body: some View {
		Text("Hey \(test)")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
