package com.velogica.seshuchennupati.velogica.utils;

import java.time.LocalDate;

/** Demonstration interface describing information for a single prescription. */
public interface Drug {

	
	/*** @return the date this drug was initially prescribed */
	public LocalDate getDatePrescribed();
	
	
	/*** @return the number of days supply this prescription was issued for */
	public int getDaysSupply();
	
	
	/*** @return the name of the drug */
	public String getDrugName();
}
