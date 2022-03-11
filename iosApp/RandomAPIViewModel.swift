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
    
    @Published var num = "1"
    @Published var lowerBound = "1"
    @Published var upperBound = "100"
    
    @Published var resultList: [Int] = []
    @Published var isError = false
    
    private let kmmRandomRepo = RandomRepository()
    
    func generateValues(){
        if let unwrappedNum = Int32(num), let unwrappedLower = Int32(lowerBound), let unwrappedUpperBound = Int32(upperBound) {
            kmmRandomRepo.generateRandomInteger(num: unwrappedNum, lowerBound: unwrappedLower, upperBound: unwrappedUpperBound){value,_ in
                if let valueUnwrapped = value, valueUnwrapped.count != 0{
                    self.resultList = valueUnwrapped.map{Int(truncating: $0)}
                }
            }
        }
    }
}
