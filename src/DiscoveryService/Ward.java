/**
 * 
 */
package DiscoveryService;

import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 * @author Sean
 *
 */
public class Ward extends DiscoveryService{
	
	/**
	 * Constructor for Ward class
	 * @param latitude
	 * @param longitude
	 */
	public Ward(String latitude, String longitude) {
		super(latitude, longitude);
		super.setSet("wards");
	}

	/**
	 * parses Json response
	 * @param JsonObject 
	 * @return String array [alderman,ward]
	 */
	@Override
	public String[] parseResponse(JsonObject json) {
		String[] wardArray = new String[2];
		JsonArray results = json.getJsonArray("objects");
		for(JsonObject result : results.getValuesAs(JsonObject.class)) {
			JsonObject x1 = result.getJsonObject("metadata");
			wardArray[0] = x1.getJsonString("ALDERMAN").getString();
			wardArray[1] = x1.getJsonString("WARD").getString();
		}
		return wardArray;
	}
}
