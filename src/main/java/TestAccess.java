import java.util.HashMap;
import java.util.Map;

public class TestAccess implements AccessObject {

	@Override
	public String getSize(int size) {
		Map<String, Integer> minSizeMap = new HashMap<String, Integer>();
		Map<String, Integer> maxSizeMap = new HashMap<String, Integer>();
		
		minSizeMap.put("XS", 0);
		minSizeMap.put("S", 35);
		minSizeMap.put("M", 50);
		minSizeMap.put("L", 65);
		minSizeMap.put("XL", 80);
		
		maxSizeMap.put("XS", 35);
		maxSizeMap.put("S", 50);
		maxSizeMap.put("M", 65);
		maxSizeMap.put("L", 80);
		maxSizeMap.put("XL", 300);
		
		if(size > minSizeMap.get("XS") && size <= maxSizeMap.get("XS")) {
			return "XS";
		}
		else if(size > minSizeMap.get("S") && size <= maxSizeMap.get("S")) {
			return "S";
		}
		else if(size > minSizeMap.get("M") && size <= maxSizeMap.get("M")) {
			return "M";
		}
		else if(size > minSizeMap.get("L") && size <= maxSizeMap.get("L")) {
			return "L";
		}
		else if(size > minSizeMap.get("XL") && size <= maxSizeMap.get("XL")) {
			return "XL";
		}
		else {
			return "Keine passende Größe gefunden.";
		}
	}

}
