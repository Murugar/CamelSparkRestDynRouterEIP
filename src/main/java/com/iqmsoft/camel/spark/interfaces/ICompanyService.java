package com.iqmsoft.camel.spark.interfaces;

import java.util.Collection;
import com.iqmsoft.camel.spark.Company;

public interface ICompanyService {
	Company getCompany(int id);
	Collection<Company> listCompanies();
	void addCompany(Company c);
	void setRatio(double ratio);
	double getRatio();
}