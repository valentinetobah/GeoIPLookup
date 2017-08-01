/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.ratendate.countrylookupapi;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author tobah
 */
@Named("lookup")
@SessionScoped
public class GeoIPLookup implements Serializable {

    private String ipAddress;
    private String responseMessage;
    private final String IPADDRESS_PATTERN
            = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private GeoIPLookupService geoIPlookupService = new GeoIPLookupService();

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getIPADDRESS_PATTERN() {
        return IPADDRESS_PATTERN;
    }

    public String getCountryName() {
        responseMessage = geoIPlookupService.displayCountry(ipAddress);
        System.out.println(responseMessage);
        return null;

    }

//    public static void main(String[] args) {
//        GeoIPLookup service = new GeoIPLookup();
//        service.setIpAddress("41.169.42.41");
//        System.out.println("The country is: " + service.getCountryName());
//    }
}
