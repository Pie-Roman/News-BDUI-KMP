import CommonUmbrella

public let divkitModule = makeDivkitModule()

private func makeDivkitModule() -> DIModule {
    DivkitModuleAssembler.shared.assembleModule(
        childModules: [],
        bridge: DivkitModuleBridgeImpl()
    )
    return DivkitModuleAssembler.shared.instance
}

private class DivkitModuleBridgeImpl: DivkitModuleBridge {
    
    override func provideNativeInstances(builder: any DIBuilder) {
        
    }
}
