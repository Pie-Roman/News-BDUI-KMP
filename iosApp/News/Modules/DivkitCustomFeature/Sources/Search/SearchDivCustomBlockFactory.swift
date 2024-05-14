import DivKit
import LayoutKit
import SearchFeature
import UIKit

public class SearchDivCustomBlockFactory: DivCustomBlockFactory {
    
    public func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> Block {
        
        let view = SearchView()
        let block = GenericViewBlock(content: .view(view), width: .resizable, height: .fixed(40))
        
        return block
    }
}
