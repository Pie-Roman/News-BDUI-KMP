import CommonUmbrella
import Serialization
import DivKit

internal class DivDataParser {
    
    func parse(rawDivData: String) throws -> DivData {
        guard let data = rawDivData.data(using: .utf8) else { throw DeserializationError.noData }
        
        return try RawDivData(JSONData: data).resolve().unwrap()
    }
}
