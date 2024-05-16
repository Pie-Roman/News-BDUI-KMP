import DivKit
import CommonUmbrella

internal class DivKitComponentsFactory {
    
    private let divCustomBlockFactory: DivCustomBlockFactory = Inject.shared.taggedInstance(tag: "DivCustomBlockFactory") as! DivCustomBlockFactory
    
    private let divPatchProvider: DivPatchProvider = DivPatchProviderImpl()
    
    func create() -> DivKitComponents {
        let divkitComponents = DivKitComponents(
            divCustomBlockFactory: divCustomBlockFactory,
            patchProvider: divPatchProvider
        )
        
        return divkitComponents
    }
}
