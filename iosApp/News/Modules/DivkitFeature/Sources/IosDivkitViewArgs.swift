import CommonUmbrella

public class IosDivkitViewArgs: DivkitViewArgs {
    public let query: String
    
    public init(query: String) {
        self.query = query
    }
}
