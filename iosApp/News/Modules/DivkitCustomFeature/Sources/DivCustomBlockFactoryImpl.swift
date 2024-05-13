import DivKit
import LayoutKit
import CommonUmbrella

class DivCustomBlockFactoryImpl: DivCustomBlockFactory {
    
    func makeBlock(data: DivKit.DivCustomData, context: DivKit.DivBlockModelingContext) -> any Block {
        return SeparatorBlock()
    }
}
