package com.velogica.seshuchennupati.velogica.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DrugListImpl implements DrugList {

	private List<Drug> druglist= new ArrayList<Drug>();
	
	@Override
	public List<Drug> getDrugsByName(String name) {
		return druglist.stream()
				.filter(d->d.getDrugName().equals(name))
				.collect(Collectors.toList());
	}

	@Override
	public List<Drug> getAllDrugs() {
		return druglist;
	}

	public DrugListImpl() {
		super();
	}

	public DrugListImpl(List<Drug> druglist) {
		super();
		this.druglist = druglist;
	}
	
	

}
