import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject var viewModel:PostViewModel
    

	var body: some View {
        ScrollView{
            
            if case .loading = viewModel.postState {
                VStack{
                    ActivityIndicator()
                        .frame(width: 50, height: 50)
                        .foregroundColor(.orange)
                }
            } else if case .success(let data) = viewModel.postState{
                VStack(alignment : .leading){
                    ForEach(data, id: \.id) { data in
                        VStack(alignment : .leading){
                            Text("ID : \(data.id)")
                                .foregroundColor(.black)
                                .font(.largeTitle)
                            Text(data.body)
                                .foregroundColor(.gray)
                                .font(.body)
                                .padding(.top,5)
                        }.padding(10)
                    }
                }
            } else if case .error(_) = viewModel.postState{
                Text("error")
            }
        }
	}

}



struct ActivityIndicator: View {
    
    @State private var isAnimating: Bool = false
    
    var body: some View {
        GeometryReader { (geometry: GeometryProxy) in
            ForEach(0..<5) { index in
                Group {
                    Circle()
                        .frame(width: geometry.size.width / 5, height: geometry.size.height / 5)
                        .scaleEffect(calcScale(index: index))
                        .offset(y: calcYOffset(geometry))
                }.frame(width: geometry.size.width, height: geometry.size.height)
                    .rotationEffect(!self.isAnimating ? .degrees(0) : .degrees(360))
                    .animation(Animation
                                .timingCurve(0.5, 0.15 + Double(index) / 5, 0.25, 1, duration: 1.5)
                                .repeatForever(autoreverses: false))
            }
        }
        .aspectRatio(1, contentMode: .fit)
        .onAppear {
            self.isAnimating = true
        }
    }
    
    func calcScale(index: Int) -> CGFloat {
        return (!isAnimating ? 1 - CGFloat(Float(index)) / 5 : 0.2 + CGFloat(index) / 5)
    }
    
    func calcYOffset(_ geometry: GeometryProxy) -> CGFloat {
        return geometry.size.width / 10 - geometry.size.height / 2
    }
    
}
