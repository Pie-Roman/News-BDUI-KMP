import DivKit
import LayoutKit
import SearchFeature
import UIKit

public class SearchDivCustomBlockFactory: DivCustomBlockFactory {
    
    public func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> Block {
        
        let view = SearchView()
        
        return GenericViewBlock(view: view)
    }
}
