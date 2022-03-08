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
    
    private let kmmRandomRepo = RandomRepository()
    
    func load(){
        kmmRandomRepo.generateRandomInteger(num: 1,lowerBound: 1,upperBound: 6){value,_ in
            if let value = value {
                self.data = String(Int(truncating: value[0]))
            }
        }
    }
}
