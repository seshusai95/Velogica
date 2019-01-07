package com.velogica.seshuchennupati.velogica;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.velogica.seshuchennupati.velogica.rules.UnderwritingRule;
import com.velogica.seshuchennupati.velogica.rules.UwRuleImpl;
import com.velogica.seshuchennupati.velogica.utils.ApplicantInfo;
import com.velogica.seshuchennupati.velogica.utils.ApplicantInfoImpl;
import com.velogica.seshuchennupati.velogica.utils.Drug;
import com.velogica.seshuchennupati.velogica.utils.DrugImpl;
import com.velogica.seshuchennupati.velogica.utils.DrugList;
import com.velogica.seshuchennupati.velogica.utils.DrugListImpl;

import static com.velogica.seshuchennupati.velogica.utils.VelogicaConstants.RuleConstants.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VelogicaApplicationTests {

	private UnderwritingRule underwritingRule= new UwRuleImpl();
	private List<Drug> drugs; 
	
@Before
public void beforeTest()
{
	  drugs = new ArrayList<Drug>();
}
	@Test
	public void totaldayslessthanthirty() 
	{
		drugs.add(new DrugImpl(drugName, LocalDate.of(2017, Month.APRIL, 22), 20));
		drugs.add(new DrugImpl(drugName, LocalDate.of(2013, Month.AUGUST, 20), 9));
		assertEquals(0, underwritingRule.underwrite(getDrugList(drugs),getApplicantInfo("male", 20, false)));
	}
	
	@Test
	public void totaldaysmorethanthirtyandyearsmorethantwo() 
	{
		drugs.add(new DrugImpl(drugName, LocalDate.of(2010, Month.APRIL, 22), 45));
		drugs.add(new DrugImpl(drugName, LocalDate.of(2014, Month.FEBRUARY, 9),10));
		assertEquals(50, underwritingRule.underwrite(getDrugList(drugs),getApplicantInfo("male", 20, false)));
	}

	@Test
	public void totaldaysmorethanthirtyyearslessthantwocatowner() 
	{
		drugs.add(new DrugImpl(drugName, LocalDate.of(2017, Month.APRIL, 22), 45));
		drugs.add(new DrugImpl(drugName, LocalDate.of(2008, Month.NOVEMBER, 12), 22));
		assertEquals(125, underwritingRule.underwrite(getDrugList(drugs),getApplicantInfo("male", 20, true)));
	}
	
	@Test
	public void totaldaysmorethanthirtyyearslessthantwonotcatowner() 
	{
		drugs.add(new DrugImpl(drugName, LocalDate.of(2017, Month.APRIL, 22), 45));
		assertEquals(250, underwritingRule.underwrite(getDrugList(drugs),getApplicantInfo("male", 20, false)));
	}
	
	public DrugList getDrugList(List<Drug> drugs) {
		return new DrugListImpl(drugs);
	}
	public ApplicantInfo getApplicantInfo(String gender, int age, boolean catowner) {
		return new ApplicantInfoImpl(gender, age, catowner);
	}
	
	@After
	public void afterTest() {
		drugs.clear();
	}
	
}
