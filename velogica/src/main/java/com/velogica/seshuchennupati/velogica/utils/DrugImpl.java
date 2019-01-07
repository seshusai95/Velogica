package com.velogica.seshuchennupati.velogica.utils;

import java.time.LocalDate;

public class DrugImpl implements Drug {

	private String drugName;
	private LocalDate datePrescribed;
	private int daysSupply;
	@Override
	public LocalDate getDatePrescribed() {
		return this.datePrescribed;
	}

	@Override
	public int getDaysSupply() {
		return this.daysSupply;
	}

	@Override
	public String getDrugName() {
		return this.drugName;
	}


	public DrugImpl() {
		super();
	}
	
	public DrugImpl(String drugName, LocalDate datePrescribed, int daysSupply) {
		super();
		this.drugName = drugName;
		this.datePrescribed = datePrescribed;
		this.daysSupply = daysSupply;
	}

	

}
