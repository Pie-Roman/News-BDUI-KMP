import UIKit
import CommonUmbrella

open class MvpUIView: UIView {
    
    open func provideMvpDelegate() -> MvpDelegate<any MvpView> {
        fatalError("Mvp delegate not provided!")
    }
    
    private lazy var mvpDelegate: MvpDelegate<any MvpView> = {
        provideMvpDelegate()
    }()
    
    public override init(frame: CGRect) {
        super.init(frame: frame)
        mvpDelegate.onCreate()
        mvpDelegate.onAttach()
    }
    
    deinit {
        mvpDelegate.onDetach()
        mvpDelegate.onDestroy()
    }
    
    required public init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
