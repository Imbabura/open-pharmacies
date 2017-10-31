package com.pharmaciesopen.controllers;

import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pharmaciesopen.services.PharmacyService;

@Component
@Path("pharmacies")
public class PharmacyController {
	@Autowired
	private PharmacyService pharmacyService;
	
	public PharmacyService getPharmacyService() {
		return pharmacyService;
	}

	public void setPharmacyService(PharmacyService pharmacyService) {
		this.pharmacyService = pharmacyService;
	}
}
