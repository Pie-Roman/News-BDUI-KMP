//
//  DivPatchProviderImpl.swift
//  News
//
//  Created by Роман Ломтев on 11.05.2024.
//

import DivKit
import CommonUmbrella
import Serialization
import Foundation

internal class DivPatchProviderImpl : DivPatchProvider {
    
    private let getViewPatchDataUseCase = Inject.shared.taggedInstance(tag: "GetViewPatchDataUseCase") as! GetViewPatchDataUseCase
    
    func getPatch(url: URL, completion: @escaping DivKit.DivPatchProviderCompletion) {
        getViewPatchDataUseCase.execute(path: url.absoluteString) { rawPatchData, error in
            guard
                let data = rawPatchData?.rawPatchData.data(using: .utf8),
                let divPatch = try? parseDivPatch(data)
            else { return }
            
            DispatchQueue.main.async {
                completion(Result.success(divPatch))
            }
        }
    }
    
    func cancelRequests() {
    }
}
