import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			MainView()
                .preferredColorScheme(.dark)
		}
	}
}
