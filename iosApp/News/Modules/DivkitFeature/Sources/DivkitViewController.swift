import Foundation
import BaseUiKit
import CommonUmbrella
import DivKit

public class DivkitViewController: MvpViewController {
    
    private let args: DivkitViewArgs
    private let divkitPresenterFactory = Inject.shared.taggedInstance(tag: "DivkitPresenterFactory") as! DivkitPresenterFactory
    private let divDataParser = DivDataParser()
    private let divkitComponentsFactory = DivKitComponentsFactory()

    public init(args: DivkitViewArgs) {
        self.args = args
        super.init()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    public override func provideMvpDelegate() -> MvpDelegate<any MvpView> {
        return DivkitMvpViewCompanion.shared.makeMvpDelegate(self) {
            self.divkitPresenterFactory.create(viewArgs: self.args)
        }
    }
}

extension DivkitViewController: DivkitMvpView {
    
    public func showError() {
        
    }
    
    public func showLoading() {
        
    }
    
    public func showNetworkError() {
        
    }
    
    public func showView(viewData: ViewData) {
        let divData = try! divDataParser.parse(rawDivData: viewData.rawDivData)

        let cardId = DivCardID(rawValue: divData.logId)
                    
        let divkitComponents = divkitComponentsFactory.create()
        
        let divViewPreloader = DivViewPreloader(divKitComponents: divkitComponents)
        let divView = DivView(divKitComponents: divkitComponents, divViewPreloader: divViewPreloader)
        view.addSubview(divView)
        divViewPreloader.setSource(.init(kind: .divData(divData), cardId: cardId))
        divView.showCardId(DivCardID(rawValue: divData.logId))
        let frame = view.bounds.inset(by: view.safeAreaInsets)
        divView.frame = frame
        divView.onVisibleBoundsChanged(to: view.bounds.intersection(frame))
    }
}
