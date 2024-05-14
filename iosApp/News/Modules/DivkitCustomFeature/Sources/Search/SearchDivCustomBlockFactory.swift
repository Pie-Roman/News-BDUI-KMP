import DivKit
import LayoutKit
import SearchFeature
import UIKit
import CommonUmbrella

public class SearchDivCustomBlockFactory: DivCustomBlockFactory {
    
    public func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> Block {
        let cardId = context.cardId
        
        if let searchInputVariableName = data.data["keySearchInput"] as? String {
            
        }
        
        let view = SearchView()
        let block = GenericViewBlock(content: .view(view), width: .resizable, height: .fixed(40))
        
        return block
    }
}
