import DivKit
import LayoutKit
import SearchFeature
import UIKit

public class SearchDivCustomBlockFactory: DivCustomBlockFactory {
    
    public func makeBlock(data: DivCustomData, context: DivBlockModelingContext) -> Block {
        
        let view = SearchView(frame: .zero)
        let block = GenericViewBlock(view: view)
        block.configureBlockView(<#T##view: any BlockView##any BlockView#>, observer: <#T##(any ElementStateObserver)?#>, overscrollDelegate: <#T##(any ScrollDelegate)?#>, renderingDelegate: <#T##(any RenderingDelegate)?#>)
        
        return block
    }
}
