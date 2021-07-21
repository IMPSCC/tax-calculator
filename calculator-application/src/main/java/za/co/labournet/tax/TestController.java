package za.co.labournet.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/taxcalculation")
public class TestController {
	
	private TaxTableRepository taxRepository;
	private RebateRepository rebateRepository;
	private MedicalAidCreditsRepository medicalAidCreditRepository;
	
	public TestController(TaxTableRepository taxRepository, RebateRepository rebateRepository,MedicalAidCreditsRepository medicalAidCreditRepository) {
		this.taxRepository = taxRepository;
		this.rebateRepository = rebateRepository;
		this.medicalAidCreditRepository = medicalAidCreditRepository;
	}
	
	@PostMapping
	public Results calculateTaxAmount(@RequestBody TaxInput taxInput) {
		
		System.out.println("Inside the SpringBoot via Post !!!!!!!!!!!   : "+taxInput.getTaxYear());
		System.out.println("Inside the SpringBoot via Post !!!!!!!!!!!   @ : "+taxInput.getAge());
		System.out.println("Inside the SpringBoot via Post !!!!!!!!!!!   : "+taxInput.getMedicalAidMembers());
		System.out.println("Inside the SpringBoot via Post !!!!!!!!!!!   @ : "+taxInput.getTotalTaxableIncome());
		
		Integer monthlyTaxAmount = 0; // TODO: CREATE CONSTANT CLASS.
		Integer monthlyTaxableAmount = taxInput.getTotalTaxableIncome();
		Integer taxYear = Integer.valueOf(taxInput.getTaxYear());
		Integer annualTaxableAmount = monthlyTaxableAmount * 12;// TODO: CREATE CONSTANT CLASS.
		
		TaxTable taxBracket = getTaxBracket(taxYear, monthlyTaxableAmount);
		Integer rebateAmount = getRebate(taxYear, taxInput.getAge());
		
		if(taxBracket.getTaxableIncomeMinimumAmountRange() == 0) {// TODO: CREATE CONSTANT CLASS.
			
			BigDecimal portionabletaxAmount =  (new BigDecimal (monthlyTaxableAmount).multiply(taxBracket.getTaxableIncomePercent())); 
			BigDecimal totalTaxExclrebate = portionabletaxAmount.add(new BigDecimal(taxBracket.getDefaultTaxAmount()));
			BigDecimal totalTaxInclRebate = totalTaxExclrebate.subtract(new BigDecimal(rebateAmount));
			monthlyTaxAmount  = (totalTaxInclRebate.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN)).intValue();
		}
		else if(taxBracket.getTaxableIncomeMaximumAmountRange() == 0)// TODO: CREATE CONSTANT CLASS.
		{
			Integer taxableAmount = annualTaxableAmount - taxBracket.getTaxableIncomeMinimumAmountRange();
			BigDecimal portionabletaxAmount =  (new BigDecimal (taxableAmount).multiply(taxBracket.getTaxableIncomePercent())); 
			BigDecimal totalTaxExclrebate = portionabletaxAmount.add(new BigDecimal(taxBracket.getDefaultTaxAmount()));
			BigDecimal totalTaxInclRebate = totalTaxExclrebate.subtract(new BigDecimal(rebateAmount));
			monthlyTaxAmount  = (totalTaxInclRebate.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN)).intValue();
		}
		else
		{
			Integer taxableAmount = annualTaxableAmount - taxBracket.getTaxableIncomeMinimumAmountRange();
			System.out.println("TaxableIncomeMinimumAmountRange returned :======> "+taxBracket.getTaxableIncomeMinimumAmountRange());
			System.out.println("taxableAmount returned :======> "+taxableAmount);
			System.out.println("TaxableIncomePercent returned :======> "+taxBracket.getTaxableIncomePercent());
			BigDecimal portionabletaxAmount =  (new BigDecimal (taxableAmount).multiply(taxBracket.getTaxableIncomePercent())); 
			System.out.println("portionabletaxAmount returned :======> "+portionabletaxAmount);
			BigDecimal totalTaxExclrebate = portionabletaxAmount.add(new BigDecimal(taxBracket.getDefaultTaxAmount()));
			System.out.println("DefaultTaxAmount returned :======> "+taxBracket.getDefaultTaxAmount());
			BigDecimal totalTaxInclRebate = totalTaxExclrebate.subtract(new BigDecimal(rebateAmount));
			monthlyTaxAmount  = (totalTaxInclRebate.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN)).intValue();
		}
		
		Results r = getResults(monthlyTaxAmount,determineMedicalAidTaxCredits(taxInput),taxInput.getTotalTaxableIncome());
		System.out.println("Inside the  "+ r.getAnnulTax());
		System.out.println("Inside the : "+r.getMonthlySalaryAfterTax());
		System.out.println("Inside the Spring "+r.getMonthlyTax());
		System.out.println("Inside the SpringBoot via Post !!!!!!!!!!!   @ : "+r.getMonthlySalaryAfterTaxCredits());
		return r;
	}
	
	private Results getResults(Integer monthlyTaxAmount,Integer taxCredit,Integer monthlySalary) {
		
		int annualTax = monthlyTaxAmount * 12;// TODO: CREATE CONSTANT CLASS.
		int salaryAfterTax = monthlySalary - monthlyTaxAmount;
		int salaryAfterTaxCredits = salaryAfterTax + taxCredit;
		
		return new Results(monthlyTaxAmount,annualTax,taxCredit,salaryAfterTax,salaryAfterTaxCredits);
	}
	
	
	private int determineMedicalAidTaxCredits(TaxInput taxInput) {
		
		int medicalAidMembers = taxInput.getMedicalAidMembers();
		int totalMedicalAidCredit = 0; // TODO: CREATE CONSTANT CLASS.
		
		while(medicalAidMembers > 0) {// TODO: CREATE CONSTANT CLASS.
			for(MedicalTaxCredits item : medicalAidCreditRepository.findAll()) {
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(item.getYear());
				
				if(calendar.get(Calendar.YEAR) == Integer.valueOf(taxInput.getTaxYear())) 
				{
					if(MedicalAidMemberKey.MAIN.getMemberKey() == item.dependantKey) {
						totalMedicalAidCredit = totalMedicalAidCredit + item.taxCreditAmount;
						medicalAidMembers--;
						break;
					}
					if(MedicalAidMemberKey.ANY.getMemberKey() == item.dependantKey) {
						totalMedicalAidCredit = totalMedicalAidCredit + item.taxCreditAmount;
						medicalAidMembers--;
						break;
					}
					if(MedicalAidMemberKey.SECONDARY.getMemberKey() == item.dependantKey) {
						totalMedicalAidCredit = totalMedicalAidCredit + item.taxCreditAmount;
						medicalAidMembers--;
						break;
					}
				}
			}
			medicalAidMembers--;
		}
		return totalMedicalAidCredit;	
	}
	
	private TaxTable getTaxBracket(Integer year, Integer salary) {
		
		salary = salary *12;// TODO: CREATE CONSTANT CLASS.            
		for(TaxTable item : taxRepository.findAll()) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(item.getTaxYear());
			System.out.println(" amount min : "+item.getTaxableIncomeMinimumAmountRange()+" amount max : "+item.getTaxableIncomeMaximumAmountRange()+" year : "+calendar.get(Calendar.YEAR));
			if((item.getTaxableIncomeMaximumAmountRange() > salary && salary > item.getTaxableIncomeMinimumAmountRange()) && calendar.get(Calendar.YEAR) == year) {
				return item;
			}
		}
		return null;
	}
	
	private Integer getRebate(Integer year,Integer age) {
		
		int rebateAmount = 0;
		for(TaxRebate item : rebateRepository.findAll()) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(item.getTaxYear());
			
			if((item.getMinimumAge() < age && item.getMaximumAge() > age) && calendar.get(Calendar.YEAR) == year) {
				System.out.println("Rebate returned :======> "+item.getRebateAmount().intValue());
				return item.getRebateAmount().intValue();
			}
		}
		
		return rebateAmount;
	}

}
