package com.velogica.seshuchennupati.velogica.utils;

import java.util.List;

/** Demonstration interface which provides a list of drugs in a drug profile. */
public interface DrugList {
	
		/*** Given a drug name, return all drugs in the prescription profile with that name.
		* @param name
		* @return an ArrayList of all Drug objects in the prescription profile with a given name. */
	// what is the need for this method?
		public List<Drug> getDrugsByName(String name);
	
		
		/*** Return a list of all drugs in the prescription profile.
		* @return an ArrayList of all Drug objects in the prescription profile. */
		public List<Drug> getAllDrugs();
		}
