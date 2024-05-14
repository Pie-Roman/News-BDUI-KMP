import UIKit
import BaseUiKit
import CommonUmbrella

public class SearchView: MvpUIView, SearchMvpView {
    
    private let searchIv = UIImageView()
    private let searchTf = UITextField()
    private let cancelB = UIButton()
    
    private var onSearchInput: ((String) -> Void)? = nil
    private var onCancelClick: (() -> Void)? = nil
    
    private let searchPresenterFactory = Inject.shared.taggedInstance(tag: "SearchPresenterFactory") as! SearchPresenterFactory
    
    public init() {
        super.init(frame: .zero)
        setupView()
    }
    
    required init(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    public override func provideMvpDelegate() -> MvpDelegate<any MvpView> {
        return SearchMvpViewCompanion.shared.makeMvpDelegate(self) {
            self.searchPresenterFactory.create()
        }
    }
    
    public func registerOnSearchInput(onSearchInput: @escaping (String) -> Void) {
        self.onSearchInput = onSearchInput
        searchTf.addTarget(self, action: #selector(searchTfTextChanged), for: .editingChanged)
    }
    
    public func registerOnCancelClick(onCancelClick: @escaping () -> Void) {
        self.onCancelClick = onCancelClick
        cancelB.addTarget(self, action: #selector(cancelBClicked), for: .touchUpInside)
        
    }
    
    public func unregisterOnSearchInput() {
        self.onSearchInput = nil
    }
    
    public func unregisterOnCancelClick() {
        self.onCancelClick = nil
    }
    
    public func clearSearchInput() {
        searchTf.text = nil
    }
    
    public func observeSearchInput(searchInput: String) {
        
    }
    
    private func setupView() {
        backgroundColor = UIColor(hex: "#EEEEEE")
        layer.cornerRadius = 20
        autoresizingMask = [.flexibleWidth, .flexibleHeight]
        
        addSubview(searchIv)
        searchIv.image = UIImage(named: "ic_search")
        searchIv.pinLeading(to: self, 20)
        searchIv.pinTop(to: self, 11)
        searchIv.pinBottom(to: self, 11)
        
        addSubview(cancelB)
        cancelB.setImage(UIImage(named: "ic_cancel"), for: .normal)
        cancelB.pinTrailing(to: self, 20)
        cancelB.pinTop(to: self, 10)
        cancelB.pinBottom(to: self, 10)
        
        addSubview(searchTf)
        searchTf.pinLeading(to: searchIv.trailingAnchor, 10)
        searchTf.pinTop(to: self, 11)
        searchTf.pinBottom(to: self, 11)
    }
    
    @objc
    private func searchTfTextChanged() {
        guard
            let searchInput = searchTf.text,
            let onSearchInput = self.onSearchInput
        else { return }
        
        onSearchInput(searchInput)
    }
    
    @objc
    private func cancelBClicked() {
        guard
            let onCancelClick = self.onCancelClick
        else { return }
        
        onCancelClick()
    }
}
