import DivKit
import LayoutKit

class DivCustomBlockFactoryImpl: DivCustomBlockFactory {
    
    func makeBlock(data: DivKit.DivCustomData, context: DivKit.DivBlockModelingContext) -> any Block {
        return SeparatorBlock()
    }
}
