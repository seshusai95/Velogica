package com.velogica.seshuchennupati.velogica.utils;

/** * Demonstration interface which holds information about the applicant. */
public interface ApplicantInfo {
		
	    /*** @return the gender of the applicant as "MALE", "FEMALE", "NONBINARY" */
		public String getGender();
		
		
		/*** @return the age of the applicant as of the time of the application */
		public int getAge();
	
		
		
		/*** Given a string identifier of a family history question or underwriting question, provide a true/false response to that question (as
		provided by the applicant)
		* @param questiontag
		* @return */
		public Boolean getMedicalResponse(String questiontag);
		}
