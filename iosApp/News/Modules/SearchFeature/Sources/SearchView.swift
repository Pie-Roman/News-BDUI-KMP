import UIKit
import BaseUiKit

public class SearchView: UIStackView {
    
    private let searchIv = UIImageView()
    private let searchTf = UITextField()
    private let cancelIv = UIImageView()
    
    public override init(frame: CGRect) {
        super.init(frame: .zero)
        setupView()
    }
    
    required init(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupView() {
        axis = .horizontal
        backgroundColor = UIColor(hex: "#EEEEEE")
        layer.cornerRadius = 20
        autoresizingMask = [.flexibleWidth, .flexibleHeight]
        
        addSubview(searchIv)
        searchIv.image = UIImage(named: "ic_search")
        searchIv.pinLeading(to: self, 20)
        searchIv.pinTop(to: self, 11)
        searchIv.pinBottom(to: self, 11)
        
        addSubview(cancelIv)
        cancelIv.image = UIImage(named: "ic_cancel")
        cancelIv.pinTrailing(to: self, 20)
        cancelIv.pinTop(to: self, 10)
        cancelIv.pinBottom(to: self, 10)
        
        addSubview(searchTf)
        searchTf.pinLeading(lessThanOrEqualTo: searchIv.trailingAnchor, 10)
        searchTf.pinTrailing(lessThanOrEqualTo: cancelIv.leadingAnchor, 10)
        searchTf.pinTop(to: self, 11)
        searchTf.pinBottom(to: self, 11)
    }
}
