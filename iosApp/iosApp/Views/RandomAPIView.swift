import SwiftUI
import shared

struct RandomAPIView: View {

    @StateObject private var viewModel = RandomAPIViewModel()
    
    var body: some View {
        //ScrollView{
            VStack{
                if viewModel.resultList.count != 0{
                    VStack{
                        Spacer()
                        Text("Results: ")
                        List{
                            ForEach(viewModel.resultList, id: \.self){ value in
                                Text(String(value))
                                    .multilineTextAlignment(.center)
                            }
                        }
                        Button (action:{
                            viewModel.resultList = []
                        }){
                            Text("Go Back")
                                .foregroundColor(.black)
                                .padding(.all, 20)
                                .background(Color.yellow)
                        }
                        .cornerRadius(20)
                        .padding(.bottom, 50)
                        Spacer()
                    }
                } else{
                    Spacer()
                    HStack{
                        Image(systemName: "network")
                        Text("Random Generator")
                            .foregroundColor(.white)
                            .bold()
                        Image(systemName: "network")
                    }
                    .scaleEffect(2)
                    Spacer()
                    HStack{
                        Text("Number of Values: ")
                            .padding(.leading, 30)
                        TextField(viewModel.num, text: $viewModel.num)
                            .foregroundColor(Color.black)
                            .background(Color.white.opacity(0.7))
                            .multilineTextAlignment(.center)
                            .cornerRadius(20)
                    }
                    .frame(maxWidth: .infinity)
                    .padding(.all, 30)
                    .background(Color.white.opacity(0.2))
                    HStack{
                        Text("Number of Values: ")
                            .padding(.leading, 30)
                        TextField(viewModel.lowerBound, text: $viewModel.lowerBound)
                            .foregroundColor(Color.black)
                            .background(Color.white.opacity(0.7))
                            .multilineTextAlignment(.center)
                            .cornerRadius(20)
                    }
                    .frame(maxWidth: .infinity)
                    .padding(.all, 30)
                    .background(Color.white.opacity(0.2))
                    HStack{
                        Text("Upper Bound: ")
                            .padding(.leading, 30)
                        TextField(viewModel.upperBound, text: $viewModel.upperBound)
                            .foregroundColor(Color.black)
                            .background(Color.white.opacity(0.7))
                            .multilineTextAlignment(.center)
                            .cornerRadius(20)
                    }
                    .frame(maxWidth: .infinity)
                    .padding(.all, 30)
                    .background(Color.white.opacity(0.2))
                    .padding(.bottom, 50)
                    Button (action:{
                        viewModel.generateValues()
                    }){
                        Text("Generate Random Value")
                            .foregroundColor(.black)
                            .padding(.all, 20)
                            .background(Color.yellow)
                    }
                    .cornerRadius(20)
                    .padding(.bottom, 50)
                    Spacer()
                }
            }
            .background(Color(red: 30/255, green: 30/255, blue: 30/255)).ignoresSafeArea()
            .alert(isPresented: $viewModel.isError) {
                Alert(title: Text("Error in retriving the(s) value(s)."))
            }
        //}
    }
}

struct RandomAPIView_Previews: PreviewProvider {
    static var previews: some View {
        RandomAPIView()
    }
}
