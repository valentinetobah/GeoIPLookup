/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.ratendate.countrylookupapi;

import com.maxmind.geoip.LookupService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author tobah
 */
public class GeoIPLookupService {

    public String displayCountry(String ipAddress) {
        String country = "";
        try {
            ServletContext ctx = (ServletContext) FacesContext
                    .getCurrentInstance()
                    .getExternalContext().getContext();
            String file = ctx.getRealPath("/WEB-INF/resources/GeoIP.dat");
                    
            LookupService lookupService = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
            country = lookupService.getCountry(ipAddress).getName();

        } catch (IOException ex) {
            Logger.getLogger(GeoIPLookupService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return country;
    }

}
