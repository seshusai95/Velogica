package com.velogica.seshuchennupati.velogica.utils;

public class ApplicantInfoImpl implements ApplicantInfo {

	private String gender;
	private int age;
	private Boolean catowner;
	
	@Override
	public String getGender() {
		return this.gender;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public Boolean getMedicalResponse(String questiontag) {
		if(questiontag.contentEquals("CatOwner"))
		{
			return this.catowner;
		}
		return false;
	}

	public ApplicantInfoImpl() {
		super();
	}

	public ApplicantInfoImpl(String gender, int age, Boolean catowner) {
		super();
		this.gender = gender;
		this.age = age;
		this.catowner = catowner;
	}
	

}
