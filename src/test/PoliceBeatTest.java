/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DiscoveryService.PoliceBeat;

/**
 * @author Sean
 *
 */
class PoliceBeatTest {
	
	String latitude;
	String longitude;
	PoliceBeat pb;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		latitude = "44.423";
		longitude = "-88.142";
		pb = new PoliceBeat(latitude, longitude);
	}

	/**
	 * Test method for {@link DiscoveryService.DiscoveryService#getSet()}.
	 */
	@Test
	void testGetSet() {
		assertEquals("police-beats", pb.getSet());
	}

	/**
	 * Test method for {@link DiscoveryService.DiscoveryService#createUrl()}.
	 */
	@Test
	void testCreateUrl() {
		String url = "http://boundaries.tribapps.com/1.0/boundary/?contains=44.423,-88.142&sets=police-beats";
		assertEquals(url, pb.createUrl().toString());
	}

	/**
	 * Test method for {@link DiscoveryService.DiscoveryService#setSet(java.lang.String)}.
	 */
	@Test
	void testSetSet() {
		pb.setSet("Test");
		assertEquals("Test", pb.getSet());
	}
	
}
