package com.iqmsoft.camel.spark;

import java.util.Map;

import org.apache.camel.Properties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.camel.spark.interfaces.ICompanyService;

@Service
public class DynamicRouter {

	@Autowired
	ICompanyService service ;
	
	
	public String slip(Company company, @Properties Map<String, Object> properties) {
		
		Logger log = Logger.getLogger(getClass()) ;

	    // get the state from the exchange properties and keep track how many times
	    // we have been invoked
	    int invoked = 0;
	    Object current = properties.get("invoked");
	    if (current != null) {
	        invoked = Integer.valueOf(current.toString());
	    }
	    invoked++;
	    // and store the state back on the properties
	    properties.put("invoked", invoked);
	 
		if (invoked == 1) {
			if (company.getEQRatio() <= service.getRatio()) { 
				log.info("[Profit Company] Company: "+company.getName()+" CompanyEQRatio: "+company.getEQRatio()+" Ratio: "+service.getRatio());
				return "direct:profitCompany";
			}
			else { 
				log.info("[Non-Profit Company] Company: "+company.getName()+" CompanyEQRatio: "+company.getEQRatio()+" Ratio: "+service.getRatio());
				return "direct:nonProfitCompany";
			}
		}
		
	    // no more so return null
	    return null;
	}
}
