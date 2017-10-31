package com.pharmaciesopen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pharmacies")
public class Pharmacy implements Serializable {

	private static final long serialVersionUID = -8273635085096165345L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="phones_numbers")
	private List<String> phonesNumbers;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	public Pharmacy() {}
	
	public Pharmacy(String name, List<String> phonesNumbers, Address address) {
		setName(name);
		setPhonesNumbers(phonesNumbers);
		setAddress(address);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhonesNumbers() {
		return phonesNumbers;
	}

	public void setPhonesNumbers(List<String> phonesNumbers) {
		this.phonesNumbers = phonesNumbers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
} 
