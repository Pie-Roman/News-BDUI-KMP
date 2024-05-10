import UIKit
import DivkitFeature

class MainViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        let args = IosDivkitViewArgs(query: "news-list")
        let divkitViewController = DivkitViewController(args: args)
        navigationController?.setNavigationBarHidden(true, animated: false)
        navigationController?.pushViewController(divkitViewController, animated: false)
    }
}

