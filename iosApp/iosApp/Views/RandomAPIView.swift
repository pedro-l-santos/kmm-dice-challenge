import SwiftUI
import shared

struct RandomAPIView: View {

    @StateObject private var viewModel = RandomAPIViewModel()
    
    var body: some View {
        Text(viewModel.data).onAppear(){
            viewModel.load()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

struct RandomAPIView_Previews: PreviewProvider {
    static var previews: some View {
        RandomAPIView()
    }
}
