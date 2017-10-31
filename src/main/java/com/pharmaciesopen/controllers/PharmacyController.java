package com.pharmaciesopen.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pharmaciesopen.model.Pharmacy;
import com.pharmaciesopen.services.PharmacyService;

@Component
@Path("pharmacies")
public class PharmacyController {
	@Autowired
	private PharmacyService pharmacyService;
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getPharmacy(@PathParam("id") int id) {
		return Response.ok(getPharmacyService().getPharmacyById(id)).build();
	}
	
	@GET
	@Path("/list")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getAllPharmacies() {
		return Response.ok(getPharmacyService().getAllPharmacies()).build();
	}
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPharmacy(Pharmacy pharmacy) {
		getPharmacyService().addPharmacy(pharmacy);
		return Response.ok(pharmacy).build();
	}
	
	public PharmacyService getPharmacyService() {
		return pharmacyService;
	}

	public void setPharmacyService(PharmacyService pharmacyService) {
		this.pharmacyService = pharmacyService;
	}
}
