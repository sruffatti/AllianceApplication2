/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DiscoveryService.GoogleGeocode;

/**
 * @author Sean
 *
 */
class GoogleGeocodeTest {

	/**
	 * Variable Declaration
	 */
	String address;
	String apiKey;
	String longitude;
	String latitude;
	GoogleGeocode geocode;

	
	@BeforeEach
	void setUp() throws Exception {
		address = "377 Florine Ct Cary Il 60013";
		apiKey = "AIzaSyDBMTCxp7f3iz-tM4kDH2mFpOMlDwDsGG0";
		geocode = new GoogleGeocode(address);
	}

	/**
	 * Test method for {@link GoogleGeocode#getAddress()}.
	 */
	@Test
	void testGetAddress() {
		assertEquals("377+Florine+Ct+Cary+Il+60013", geocode.getAddress());
	}

	/**
	 * Test method for {@link GoogleGeocode#getApiKey()}.
	 */
	@Test
	void testGetApiKey() {
		assertEquals(apiKey, geocode.getApiKey());
	}
	
	/**
	 * Test Method for DiscoveryService.GoogleGeocode#getCoordinates
	 * @throws IOException 
	 */
	@Test
	void testGetCoordinates() throws IOException {
		String[] coordinates = geocode.getCoordinates();
		String actualCoordinates = String.format("%s %s", coordinates[0], coordinates[1]);
		assertEquals("42.2271031 -88.24625139999999", actualCoordinates);
	}

}
