package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DiscoveryService.Ward;

class WardTest {
	
	/**
	 * Variable Declaration
	 */
	String lat;
	String lng;
	Ward ward;

	@BeforeEach
	void setUp() throws Exception {
		lat = "42.2271031";
		lng = "-88.24625139999999";
		ward = new Ward(lat, lng);
	}

	@Test
	void testCreateUrl() {
		String expected ="http://boundaries.tribapps.com/1.0/boundary/?contains=42.2271031,-88.24625139999999&sets=wards";
		assertEquals(expected, ward.createUrl().toString());
	}
	
	@Test
	void testGetSet() {
		assertEquals("wards", ward.getSet());
	}
	
	@Test
	void testSetSet() {
		ward.setSet("test");
		assertEquals("test", ward.getSet());
	}

}
