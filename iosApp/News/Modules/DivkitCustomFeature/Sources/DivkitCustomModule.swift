import CommonUmbrella
import SearchFeature

public let divkitCustomModule = makeDivkitCustomModule()

private func makeDivkitCustomModule() -> DIModule {
    DivkitCustomModuleAssembler.shared.assembleModule(
        childModules: [
            searchModule
        ],
        bridge: DivkitCustomModuleBridgeImpl()
    )
    return DivkitCustomModuleAssembler.shared.instance
}

private class DivkitCustomModuleBridgeImpl: DivkitCustomModuleBridge {
    
    override func provideNativeInstances(builder: any DIBuilder) {
        
        DIExtensionsKt.taggedProvider(builder, tag: "SearchDivCustomBlockFactory") { directDIAware in
            SearchDivCustomBlockFactory(
                observeSearchInputUseCase: DIExtensionsKt.taggedInstance(directDIAware, tag: "ObserveSearchInputUseCase") as! ObserveSearchInputUseCase
            )
        }
        
        DIExtensionsKt.taggedProvider(builder, tag: "DivCustomBlockFactory") { directDIAware in
            DivCustomBlockFactoryImpl(
                searchDivCustomBlockFactory: DIExtensionsKt.taggedInstance(directDIAware, tag: "SearchDivCustomBlockFactory") as! SearchDivCustomBlockFactory
            )
        }
    }
}
