package com.velogica.seshuchennupati.velogica.rules;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.Assert;

import com.velogica.seshuchennupati.velogica.utils.ApplicantInfo;
import com.velogica.seshuchennupati.velogica.utils.Drug;
import com.velogica.seshuchennupati.velogica.utils.DrugList;
import static com.velogica.seshuchennupati.velogica.utils.VelogicaConstants.RuleConstants.*;

public class UwRuleImpl implements UnderwritingRule {

	private int totalDays = initial_totalDays;
	private int debit = initial_debit;
	private List<LocalDate> years = new ArrayList<LocalDate>();
	private List<Drug> listOfPresciptions = new ArrayList<Drug>();

	public int underwrite(DrugList drugprofile, ApplicantInfo appinfo) {
		Assert.notNull(drugprofile, "DrugList is null");
		Assert.notNull(appinfo, "ApplicantInfo is null");
		
		// get all the prescriptions related to drug QUALASSESS
		listOfPresciptions = drugprofile.getDrugsByName(drugName);
		// get the total no.of days the applicant took the drug and add all the dates of
		// prescriptions to the List
		listOfPresciptions.forEach(drug -> {
			totalDays += drug.getDaysSupply();
			years.add(drug.getDatePrescribed());
		});
		int totalperiod = Period.between(Collections.max(years), LocalDate.now()).getYears();
		if (totalDays > 30) {
			//If the drug was prescribed for more than 30 days, but it has been less than two years since the last use
			if (totalperiod <= 2
					&& appinfo.getMedicalResponse("CatOwner")) {
				debit = 125;//assess the drug as 125 debits for cat-owners
			}else if (totalperiod > 2) {
				debit = 50;/*If the drug was prescribed for more than 30 days, but it has been 2 years or more since the
				last use, assess the drug as 50 debits.*/
			}else {
				debit = 250;
		   } 
			}else {
			debit = 0;
		}
		return debit;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public int getDebit() {
		return debit;
	}

	public List<LocalDate> getYears() {
		return years;
	}

	public List<Drug> getListOfPresciptions() {
		return listOfPresciptions;
	}


	
}
