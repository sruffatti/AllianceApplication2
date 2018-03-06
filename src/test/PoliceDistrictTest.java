package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DiscoveryService.PoliceDistrict;

class PoliceDistrictTest {
	
	String latitude;
	String longitude;
	PoliceDistrict pd;

	@BeforeEach
	void setUp() throws Exception {
		latitude = "42.654";
		longitude = "-88.187";
		pd = new PoliceDistrict(latitude, longitude);
	}

	@Test
	void testGetSet() {
		assertEquals("police-districts", pd.getSet());
	}
	
	@Test
	void testCreateUrl() {
		String url = "http://boundaries.tribapps.com/1.0/boundary/?contains=42.654,-88.187&sets=police-districts";
		assertEquals(url, pd.createUrl().toString());
	}

	@Test
	void testSetSet() {
		pd.setSet("test");
		assertEquals("test", pd.getSet());
	}
}
