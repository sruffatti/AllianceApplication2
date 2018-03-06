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
public class PoliceBeat extends DiscoveryService {

	/**
	 * Constructor for PoliceBeat
	 * @param latitude
	 * @param longitude
	 */
	public PoliceBeat(String latitude, String longitude) {
		super(latitude, longitude);
		this.setSet("police-beats");
	}

	/* (non-Javadoc)
	 * @see DiscoveryService.DiscoveryService#parseResponse(javax.json.JsonObject)
	 */
	@Override
	public String[] parseResponse(JsonObject json) {
		String[] beat = new String[1];
		JsonArray results = json.getJsonArray("objects");
		for(JsonObject result : results.getValuesAs(JsonObject.class)) {
			JsonObject x1 = result.getJsonObject("metadata");
			beat[0] = x1.getJsonString("BEAT_NUM").getString();
		}
		return beat;
	}
}
