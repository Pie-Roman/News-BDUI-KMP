import DivKit
import LayoutKit
import SearchFeature
import UIKit
import CommonUmbrella

public class SearchDivCustomBlockFactory: DivCustomBlockFactory {
    
    private let observeSearchInputUseCase: ObserveSearchInputUseCase
    
    init(
        observeSearchInputUseCase: ObserveSearchInputUseCase
    ) {
        self.observeSearchInputUseCase = observeSearchInputUseCase
    }
    
    public func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> Block {
        let cardId = context.cardId
        let variablesStorage = context.variablesStorage
        if let searchInputVariableName = data.data["keySearchInput"] as? String {
            DispatchQueue.main.async {
                Task {
                    try await self.observeSearchInputUseCase.execute { searchInput in
                        variablesStorage.update(
                            cardId: cardId,
                            name: DivVariableName(stringLiteral: searchInputVariableName),
                            value: searchInput
                        )
                    }
                }
            }
        }
        
        let view = SearchView()
        let block = GenericViewBlock(content: .view(view), width: .resizable, height: .fixed(40))
        
        return block
    }
}
