//
//  RandomAPIViewModel.swift
//  iosApp
//
//  Created by Kyber on 08/03/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

final class RandomAPIViewModel: ObservableObject {
    @Published var data = "Loading..."
    
    let kmmRandomAPI = RandomAPI()
    
    func load(){
        kmmRandomAPI.getData(){ result, error in
            if let result = result {
                self.data = result
            } else{
                self.data = "Error: \(String(describing: error))"
            }
        }
    }
}
