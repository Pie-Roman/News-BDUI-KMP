import DivKit
import CommonUmbrella

internal class DivKitComponentsFactory {
    
    private let divPatchProvider: DivPatchProvider = DivPatchProviderImpl()
    
    func create() -> DivKitComponents {
        let divkitComponents = DivKitComponents(
            patchProvider: divPatchProvider
        )
        
        return divkitComponents
    }
}
