package model.action;

import java.util.LinkedHashMap;
import org.json.*;

public class JSONCreator {

	private static LinkedHashMap contentMap;
	
	public JSONCreator(){}	
	
	public static JSONObject createJSONObject(LinkedHashMap contentMap){
		JSONObject json = new JSONObject(contentMap);
		return json;
	}
}