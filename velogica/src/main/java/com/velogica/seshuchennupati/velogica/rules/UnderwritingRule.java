package com.velogica.seshuchennupati.velogica.rules;

import com.velogica.seshuchennupati.velogica.utils.ApplicantInfo;
import com.velogica.seshuchennupati.velogica.utils.DrugList;

/**Demonstration interface responsible for performing underwriting. */
public interface UnderwritingRule {

	/**
	* @param drugprofile - a list of prescription drugs discovered for this applicant
	* @param appinfo - applicant demographic information, and responses regarding their risk profile and medical history
	* @return debits - the underwriting debits associated with the drug profile and applicant information provided
	*/
	public int underwrite(DrugList drugprofile, ApplicantInfo appinfo);
	
}
