package DiscoveryService;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class GoogleGeocode implements GoogleAPI{
	private String address;
	private String urlPrefix;
	private String urlSuffix;
	
	/**
	 * Constructor
	 * @param address
	 */
	public GoogleGeocode(String address) {
		this.address = formatAddressForGoogleUrl(address);
		this.urlPrefix = "https://maps.googleapis.com/maps/api/geocode/json?address=";
		this.urlSuffix = "&key=";
	}

	/**
	 * getter for address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Override getApiKey method from GoogleAPI interface.
	 * @return String apiKey from interface
	 */
	@Override
	public String getApiKey() {
		return apiKey;
	}
	
	/**
	 * formats address for Google Geocode url
	 * @param address
	 * @return String address
	 */
	private String formatAddressForGoogleUrl(String address) {
		StringBuilder formattedAddress = new StringBuilder();
		String[] splitAddress = address.split(" ");
		
		for(int i = 0; i < splitAddress.length; i++) {
			if(i != splitAddress.length-1) {
				formattedAddress.append(splitAddress[i]+"+");
			}
			else {
				formattedAddress.append(splitAddress[i]);
			}
		}
		return formattedAddress.toString();
	}
	
	/**
	 * configures url using urlPrefix, address, urlSuffix, and apiKey
	 * @return URL url
	 */
	private URL configureUrl() {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(urlPrefix).append(address).append(urlSuffix).append(apiKey);
		URL url = null;
		try {
			url = new URL(urlBuilder.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * retrieves the response from Google Geocode
	 * @param url
	 * @return JsonObject obj
	 * @throws IOException
	 */
	private JsonObject retrieveGoogleGeocodeResponse(URL url) throws IOException {
		InputStream stream = url.openStream();
		JsonReader reader = Json.createReader(stream);
		JsonObject obj = reader.readObject();
		stream.close();
		return obj;
	}
	
	/**
	 * Parses Json Object to get the longitude and latitude
	 * @return Array coordinates[lat,long]
	 * @throws IOException
	 */
	public String[] getCoordinates() throws IOException {
		String[] coordinates = new String[2];
		URL url = configureUrl();
		JsonObject obj = retrieveGoogleGeocodeResponse(url);
		JsonArray results = obj.getJsonArray("results");
		for(JsonObject result : results.getValuesAs(JsonObject.class)) {
			JsonObject x = result.getJsonObject("geometry");
			coordinates[0] = (x.getJsonObject("location").getJsonNumber("lat").toString());
			coordinates[1] = (x.getJsonObject("location").getJsonNumber("lng").toString());
		}
		return coordinates;
	}
}





















