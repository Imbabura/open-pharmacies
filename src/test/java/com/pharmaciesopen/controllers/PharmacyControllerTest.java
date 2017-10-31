package com.pharmaciesopen.controllers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.json.JSONException;
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
	
	@Test
    public void testGetPharmacy() throws JSONException {
		Address addressMock= Mockito.mock(Address.class);
		Pharmacy persistedPharmacy= new Pharmacy("Pharmacy90", new ArrayList<String>(), addressMock);
		pharmacyService.addPharmacy(persistedPharmacy);
    	ResponseEntity<Pharmacy> entity= getRestTemplate().getForEntity(URL_BASE + "/" + persistedPharmacy.getId(), Pharmacy.class);
    	System.out.println(entity.getStatusCode());
    	assertTrue(entity.getStatusCode().equals(HttpStatus.OK));
		assertTrue(entity.getBody().getName().equals(persistedPharmacy.getName()));
    }
	
    public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}