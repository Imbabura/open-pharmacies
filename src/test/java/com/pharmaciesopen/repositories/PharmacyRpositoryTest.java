package com.pharmaciesopen.repositories;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
	private Address addressMock, anotherAddressMock;
	private Pharmacy pharmacy, anotherPharmacy;
	
	@Before
	public void setUp() {
		addressMock= Mockito.mock(Address.class);
		anotherAddressMock= Mockito.mock(Address.class);
		pharmacy= new Pharmacy("Pharmacy1", new ArrayList<String>(), addressMock);
		anotherPharmacy= new Pharmacy("Pharmacy2", new ArrayList<String>(), anotherAddressMock);
	}
	
	@Test
	public void testGetPharmacyById() {
		testEntityManager.persist(pharmacy);
		Pharmacy pharmacyResult= pharmacyRepository.getPharmacyById(pharmacy.getId());
		assertTrue(pharmacy.getName().equals(pharmacyResult.getName()));
	}
	
	@Test
	public void testGetAllPharmacies() {
		testEntityManager.persist(anotherPharmacy);
		testEntityManager.persist(pharmacy);
		List<Pharmacy> pharmacies= pharmacyRepository.getAllPharmacies();
		assertTrue(pharmacies.size() == 2);
	}
	
	@Test
	public void testAddPharmacy() {
		pharmacyRepository.addPharmacy(pharmacy);
		Pharmacy pharmacyResult= pharmacyRepository.getPharmacyById(pharmacy.getId());
		assertTrue(pharmacy.getName().equals(pharmacyResult.getName()));
	}
}
