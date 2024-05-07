import UIKit
import CommonUmbrella

open class MvpViewController: UIViewController {
    
    open func provideMvpDelegate() -> MvpDelegate<any MvpView> {
        fatalError("Mvp delegate not provided!")
    }
    
    private lazy var mvpDelegate: MvpDelegate<any MvpView> = {
        provideMvpDelegate()
    }()
    
    public init() {
        super.init(nibName: nil, bundle: nil)
    }
    
    required public init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    public final override func viewDidLoad() {
        super.viewDidLoad()
        mvpDelegate.onCreate()
    }
    
    public final override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        mvpDelegate.onAttach()
    }
    
    public final override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        mvpDelegate.onDetach()
    }
    
    public final override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        mvpDelegate.onDestroy()
    }
}
