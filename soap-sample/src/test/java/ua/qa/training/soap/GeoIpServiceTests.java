package ua.qa.training.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by osoboleva on 11/14/2016.
 */
public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("50.200.242.230");
        assertEquals(geoIP.getCountryCode(), "USA");
    }

    @Test
    public void testInvalidIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("50.200.242.xxx");
        assertEquals(geoIP.getCountryCode(), "USA");
    }
}
