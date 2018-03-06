/**
 * 
 */
package DiscoveryService;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * @author Sean
 *
 */
public abstract class DiscoveryService {
	public final String urlPrefix;
	public final String urlSuffix;
	public String set;
	public String latitude;
	public String longitude;
	
	/**
	 * constructor
	 * @param latitude
	 * @param longitude
	 */
	public DiscoveryService(String latitude, String longitude) {
		this.urlPrefix = "http://boundaries.tribapps.com/1.0/boundary/?contains=";
		this.urlSuffix = "&sets=";
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * getter for set
	 * @return String set
	 */
	public String getSet() {
		return set;
	}
	
	/**
	 * setter for set
	 * @param _set
	 */
	public void setSet(String _set) {
		set = _set;
	}
	
	/**
	 * Uses a StringBuilder object to append the urlPrefix, urlSuffix, latitude, longitude and set into a single string. Then creates URL object.
	 * @return URL url. 
	 */
	public URL createUrl() {
		StringBuilder urlBuilder = new StringBuilder(); 
		urlBuilder.append(this.urlPrefix).append(this.latitude).append(",").append(this.longitude).append(this.urlSuffix).append(this.set);
		URL url = null;
		try {
			url = new URL(urlBuilder.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * Handles json response from url.
	 * @param url
	 * @return JsonObject obj
	 * @throws IOException
	 */
	public JsonObject retrieveWebServiceReponse(URL url) throws IOException {
		InputStream stream = url.openStream();
		JsonReader reader = Json.createReader(stream);
		JsonObject obj = reader.readObject();
		stream.close();
		return obj;
	}
	
	/**
	 * abstract method 
	 * @return String array
	 */
	abstract public String[] parseResponse(JsonObject json);
}
