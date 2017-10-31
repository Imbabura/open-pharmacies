package com.pharmaciesopen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmaciesopen.model.Pharmacy;
import com.pharmaciesopen.repositories.PharmacyRepository;

@Service
public class PharmacyService {
	@Autowired
	private PharmacyRepository pharmacyRepository;
	
	public Pharmacy getPharmacyById(int pharmacyId) {
		return getPharmacyRepository().getPharmacyById(pharmacyId);
	}
	
	public List<Pharmacy> getAllPharmacies() {
		return getPharmacyRepository().getAllPharmacies();
	}
	
	public void addPharmacy(Pharmacy pharmacy) {
		getPharmacyRepository().addPharmacy(pharmacy);
	}
	
	public PharmacyRepository getPharmacyRepository() {
		return pharmacyRepository;
	}

	public void setPharmacyRepository(PharmacyRepository pharmacyRepository) {
		this.pharmacyRepository = pharmacyRepository;
	}
}
