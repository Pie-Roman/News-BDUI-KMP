import DivKit
import LayoutKit
import CommonUmbrella

class DivCustomBlockFactoryImpl: DivCustomBlockFactory {
    
    private let searchDivCustomBlockFactory: SearchDivCustomBlockFactory
    
    init(
        searchDivCustomBlockFactory: SearchDivCustomBlockFactory
    ) {
        self.searchDivCustomBlockFactory = searchDivCustomBlockFactory
    }
    
    func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> any Block {
        return switch DivCustomType(rawValue: data.name) {
        case .search:
            searchDivCustomBlockFactory.makeBlock(data: data, context: context)
        case .none:
            SeparatorBlock()
        }
    }
}
