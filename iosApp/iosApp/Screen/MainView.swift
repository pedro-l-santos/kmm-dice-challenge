import SwiftUI
import shared

struct MainView: View {

    var body: some View {
        TabView{
            DiceView()
                .tabItem{
                    Label("Dice", systemImage: "dice")
                }
            APIView()
                .tabItem{
                    Label("API", systemImage: "house")
                }
                .background(Color(red: 30/255, green: 30/255, blue: 30/255)).ignoresSafeArea()
        }
        .accentColor(.yellow)
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}

