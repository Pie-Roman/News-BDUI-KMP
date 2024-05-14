import CommonUmbrella

public let divkitCustomModule = makeDivkitCustomModule()

private func makeDivkitCustomModule() -> DIModule {
    DivkitCustomModuleAssembler.shared.assembleModule(
        childModules: [],
        bridge: DivkitCustomModuleBridgeImpl()
    )
    return DivkitCustomModuleAssembler.shared.instance
}

private class DivkitCustomModuleBridgeImpl: DivkitCustomModuleBridge {
    
    override func provideNativeInstances(builder: any DIBuilder) {
        
        DIExtensionsKt.taggedProvider(builder, tag: "SearchDivCustomBlockFactory") { _ in
            SearchDivCustomBlockFactory()
        }
        
        DIExtensionsKt.taggedProvider(builder, tag: "DivCustomBlockFactory") { directDIAware in
            DivCustomBlockFactoryImpl(
                searchDivCustomBlockFactory: Inject.shared.taggedInstance(tag: "SearchDivCustomBlockFactory") as! SearchDivCustomBlockFactory
            )
        }
    }
}
