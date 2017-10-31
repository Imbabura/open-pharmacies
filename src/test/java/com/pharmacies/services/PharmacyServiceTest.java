package com.pharmacies.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testGetAllPharmacies() {
		List<Pharmacy> pharmacies= new ArrayList<Pharmacy>();
		pharmacies.add(pharmacyMock);
		when(pharmacyRepository.getAllPharmacies()).thenReturn(pharmacies);
		assertEquals(1, pharmacyService.getAllPharmacies().size());
		assertEquals(pharmacyMock, pharmacyService.getAllPharmacies().get(0));
	}
	
	@Test
	public void testAddPharmacy() {
		pharmacyService.addPharmacy(pharmacyMock);
		verify(pharmacyRepository, times(1)).addPharmacy(pharmacyMock);
	}
}
