import DivKit
import LayoutKit
import SearchFeature
import UIKit
import CommonUmbrella

public class SearchDivCustomBlockFactory: DivCustomBlockFactory {
    
    private let observeSearchInputUseCase: ObserveSearchInputUseCase
    
    private var searchInputVariableName: String? = nil
    private var searchInputTriggeredVariableName: String? = nil
    
    private var cardId: DivCardID? = nil
    private var variablesStorage: DivVariablesStorage? = nil
    
    init(
        observeSearchInputUseCase: ObserveSearchInputUseCase
    ) {
        self.observeSearchInputUseCase = observeSearchInputUseCase
        
        DispatchQueue.main.async {
            Task {
                try await self.observeSearchInputUseCase.execute { [weak self] searchInput in
                    if let cardId = self?.cardId,
                       let variablesStorage = self?.variablesStorage,
                       let searchInputVariableName = self?.searchInputVariableName,
                       let searchInputTriggeredVariableName = self?.searchInputTriggeredVariableName {
                        let variables: DivVariables = [
                            DivVariableName(stringLiteral: searchInputVariableName) : .string(searchInput),
                            DivVariableName(stringLiteral: searchInputTriggeredVariableName) : .bool(true)
                        ]
                        variablesStorage.append(variables: variables, for: cardId, replaceExisting: true)
                    }
                }
            }
        }
    }
    
    public func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> Block {
        self.searchInputVariableName = data.data["keySearchInput"] as? String
        self.searchInputTriggeredVariableName = data.data["keySearchInputTriggered"] as? String
        self.cardId = context.cardId
        self.variablesStorage = context.variablesStorage
        
        let view = SearchView()
        let block = GenericViewBlock(content: .view(view), width: .resizable, height: .fixed(40))
        
        return block
    }
}
