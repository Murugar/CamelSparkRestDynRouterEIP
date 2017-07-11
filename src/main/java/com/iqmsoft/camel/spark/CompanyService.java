package com.iqmsoft.camel.spark;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.iqmsoft.camel.spark.interfaces.ICompanyService;

@Service
public class CompanyService implements ICompanyService {
	
  
    private final Map<Integer, Company> companies = new TreeMap<>();
    private double eqratioLimit = 10 ;

    public CompanyService() {
    	companies.put(100, new Company(100, "GFT", 150, 100)) ; 
    	companies.put(200, new Company(200, "MSFT", 1550, 200)) ; 
    	companies.put(300, new Company(300, "GOOG", 2550, 300)) ; 
    	companies.put(400, new Company(400, "FBOOK", 3550, 400)) ; 
    	companies.put(400, new Company(500, "LTC", 4550, 500)) ; 
    }

   
    @Override
	public Company getCompany(int id) {
        return companies.get(id);
    }

   
    @Override
	public Collection<Company> listCompanies() {
        return companies.values();
    }

    @Override
	public void addCompany (Company c) {
    	companies.put(c.getId(), c) ;
    }
    
  
    @Override
	public void setRatio (double ratio) {
    	eqratioLimit = ratio ;
    }
    
  
    @Override
	public double getRatio() {
    	return eqratioLimit ;
    }
}
