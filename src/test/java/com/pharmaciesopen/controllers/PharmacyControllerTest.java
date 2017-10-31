package com.pharmaciesopen.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pharmaciesopen.model.Address;
import com.pharmaciesopen.model.Pharmacy;
import com.pharmaciesopen.services.PharmacyService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PharmacyControllerTest {
	@Autowired
	private PharmacyService pharmacyService;
	@Autowired
	private TestRestTemplate restTemplate;
	private static final String URL_BASE= "/api/pharmacies";
	private Address addressMock;
	private Pharmacy pharmacy, anotherPharmacy;
	
	@Before
	public void setUp() {
		addressMock= Mockito.mock(Address.class);
		pharmacy= new Pharmacy("Pharmacy1", new ArrayList<String>(), addressMock);
		anotherPharmacy= new Pharmacy("Pharmacy2", new ArrayList<String>(), addressMock);
	}
	
	@Test
    public void testGetPharmacy() {
		pharmacyService.addPharmacy(pharmacy);
		ResponseEntity<Pharmacy> entity= getRestTemplate().getForEntity(URL_BASE + "/" + pharmacy.getId(), Pharmacy.class);
    	assertTrue(entity.getStatusCode().equals(HttpStatus.OK));
		assertTrue(entity.getBody().getName().equals(pharmacy.getName()));
    }
	
	@Test
    public void testGetAllPharmacies() {
		int previousNumberOfPharmacies= getRestTemplate().getForEntity(URL_BASE + "/list", Pharmacy[].class).getBody().length;
		pharmacyService.addPharmacy(anotherPharmacy);
    	ResponseEntity<Pharmacy[]> entities= getRestTemplate().getForEntity(URL_BASE + "/list", Pharmacy[].class);
    	assertTrue(entities.getStatusCode().equals(HttpStatus.OK));
		assertEquals(previousNumberOfPharmacies + 1, entities.getBody().length);
    }
	
	@Test
    public void testAddPharmacy() {
		Pharmacy pharmacy= new Pharmacy("Pharmacy3", new ArrayList<String>(), null);
    	ResponseEntity<Pharmacy> entity= getRestTemplate().postForEntity(URL_BASE + "/add", pharmacy, Pharmacy.class);
    	assertTrue(entity.getStatusCode().equals(HttpStatus.OK));
    	assertTrue(entity.getBody().getName().equals(pharmacy.getName()));
    }
	
    public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}