package com.pharmacies.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.pharmaciesopen.model.Pharmacy;
import com.pharmaciesopen.repositories.PharmacyRepository;
import com.pharmaciesopen.services.PharmacyService;

public class PharmacyServiceTest {
	
	private PharmacyService pharmacyService;
	private PharmacyRepository pharmacyRepository;
	private Pharmacy pharmacyMock;
	
	@Before
	public void setUp() {
		pharmacyRepository= Mockito.mock(PharmacyRepository.class);
		pharmacyService= new PharmacyService();
		pharmacyService.setPharmacyRepository(pharmacyRepository);
		pharmacyMock= Mockito.mock(Pharmacy.class);
	}
	
	@Test
	public void testGetPharmacyById() {
		when(pharmacyRepository.getPharmacyById(1)).thenReturn(pharmacyMock);
		assertEquals(pharmacyMock, pharmacyService.getPharmacyById(1));
	}
}
