package com.pharmaciesopen.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pharmaciesopen.model.Pharmacy;

@Transactional
@Repository
public class PharmacyRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Pharmacy getPharmacyById(int pharmacyId) {
		return entityManager.find(Pharmacy.class, pharmacyId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pharmacy> getAllPharmacies() {
		String hql= "SELECT p FROM Pharmacy p";
		return (List<Pharmacy>) entityManager.createQuery(hql).getResultList();
	}

	public void addPharmacy(Pharmacy pharmacy) {
		entityManager.persist(pharmacy);
	}
}
