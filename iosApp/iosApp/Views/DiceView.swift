import SwiftUI
import shared

struct DiceView: View {
    @StateObject private var viewModel = DiceViewModel()

	var body: some View {
            VStack{
                Spacer()
                HStack{
                    Image(systemName: "dice")
                    Text("Dice Roller")
                        .foregroundColor(.white)
                        .bold()
                    Image(systemName: "dice")
                }
                .scaleEffect(2)
                Spacer()
                HStack{
                    Spacer()
                    Text("Number of Faces:")
                        .foregroundColor(.white)
                    Spacer()
                    Picker(selection: $viewModel.numFaces, label: Text("Number of Faces")){
                        Text("4").tag(4)
                        Text("6").tag(6)
                        Text("8").tag(8)
                        Text("10").tag(10)
                        Text("12").tag(12)
                        Text("20").tag(20)
                        Text("100").tag(100)
                    }
                    .foregroundColor(.yellow)
                    Spacer()
                }
                Spacer()
                HStack{
                    Image(systemName: "dice")
                    Text("Dice Value: \(viewModel.diceValue)")
                    Image(systemName: "dice")
                }
                .foregroundColor(.white)
                .padding(.all, 30)
                .frame(maxWidth: .infinity)
                .background(Color.white.opacity(0.2))
                .cornerRadius(20)
                Spacer()
                Button (action:{
                    viewModel.rollDice()
                }){
                    Text("Roll the Dice")
                        .foregroundColor(.black)
                        .padding(.all, 20)
                        .background(Color.yellow)
                }
                .cornerRadius(20)
                Spacer()
            }
            .background(Color(red: 30/255, green: 30/255, blue: 30/255)).ignoresSafeArea()
	}
}

struct DiceView_Previews: PreviewProvider {
	static var previews: some View {
        DiceView()
	}
}
