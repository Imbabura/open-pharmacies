package com.pharmaciesopen.repositories;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pharmaciesopen.model.Address;
import com.pharmaciesopen.model.Pharmacy;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PharmacyRpositoryTest {
	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private PharmacyRepository pharmacyRepository;
	
	@Test
	public void testGetPharmacyById() {
		Address addressMock= Mockito.mock(Address.class);
		Pharmacy persistedPharmacy= new Pharmacy("Pharmacy1", new ArrayList<String>(), addressMock);
		testEntityManager.persist(persistedPharmacy);
		Pharmacy pharmacy= pharmacyRepository.getPharmacyById(persistedPharmacy.getId());
		assertTrue(persistedPharmacy.getName().equals(pharmacy.getName()));
	}
}
