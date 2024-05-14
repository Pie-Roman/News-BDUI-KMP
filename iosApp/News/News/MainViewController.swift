import UIKit
import DivkitFeature

class MainViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
        
        let args = IosDivkitViewArgs(query: "tabs")
        let divkitViewController = DivkitViewController(args: args)
        navigationController?.setNavigationBarHidden(true, animated: false)
        navigationController?.pushViewController(divkitViewController, animated: false)
    }
}

