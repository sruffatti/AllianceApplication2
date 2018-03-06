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
public class PoliceDistrict extends DiscoveryService {

	/**
	 * @param latitude
	 * @param longitude
	 */
	public PoliceDistrict(String latitude, String longitude) {
		super(latitude, longitude);
		this.setSet("police-districts");
	}

	/* (non-Javadoc)
	 * @see DiscoveryService.DiscoveryService#parseResponse(javax.json.JsonObject)
	 */
	@Override
	public String[] parseResponse(JsonObject json) {
		String[] districts = new String[1];
		JsonArray results = json.getJsonArray("objects");
		for(JsonObject result : results.getValuesAs(JsonObject.class)) {
			JsonObject x1 = result.getJsonObject("metadata");
			districts[0] = x1.getJsonString("DIST_NUM").getString();
		}
		return districts;
	}
}
