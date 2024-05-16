import CommonUmbrella

public let searchModule = makeSearchModule()

private func makeSearchModule() -> DIModule {
    SearchModuleAssembler.shared.assembleModule(
        childModules: [],
        bridge: SearchModuleBridgeImpl()
    )
    return SearchModuleAssembler.shared.instance
}

private class SearchModuleBridgeImpl: SearchModuleBridge {
}
