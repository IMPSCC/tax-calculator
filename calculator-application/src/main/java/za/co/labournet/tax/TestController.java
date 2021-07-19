package za.co.labournet.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	private TaxTableRepository taxRepository;
	private RebateRepository rebateRepository;
	
	public TestController(TaxTableRepository taxRepository, RebateRepository rebateRepository) {
		this.taxRepository = taxRepository;
		this.rebateRepository = rebateRepository;
	}
	
	@RequestMapping("/wena")
	public Collection<Results> getTaxAmount() {
		
		List<Results> results = new ArrayList<Results>();
		Integer annualTax = calculateTaxAmount() * 12;
		
		results.add(new Results(calculateTaxAmount(),annualTax));
		return results;
		
	}

	private Integer calculateTaxAmount() {
		
		Integer taxAmount = 0;
		HashMap<String,Integer> input = getInput();
		TaxTable taxBracket = getTaxBracket(input.get("taxyear"), input.get("annualsalary"));
		Integer rebateAmount = getRebate(input.get("taxyear"), input.get("age"));
		
		if(taxBracket.getTaxableIncomeMinimumAmountRange() == 0) {
			
			Integer taxableAmount = input.get("annualsalary");
			BigDecimal portionabletaxAmount =  (new BigDecimal (taxableAmount).multiply(taxBracket.getTaxableIncomePercent())); 
			BigDecimal totalTaxExclrebate = portionabletaxAmount.add(new BigDecimal(taxBracket.getDefaultTaxAmount()));
			BigDecimal totalTaxInclRebate = totalTaxExclrebate.subtract(new BigDecimal(rebateAmount));
			taxAmount  = (totalTaxInclRebate.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN)).intValue();
		}
		else if(taxBracket.getTaxableIncomeMaximumAmountRange() == 0)
		{
			Integer taxableAmount = input.get("annualsalary") - taxBracket.getTaxableIncomeMinimumAmountRange();
			BigDecimal portionabletaxAmount =  (new BigDecimal (taxableAmount).multiply(taxBracket.getTaxableIncomePercent())); 
			BigDecimal totalTaxExclrebate = portionabletaxAmount.add(new BigDecimal(taxBracket.getDefaultTaxAmount()));
			BigDecimal totalTaxInclRebate = totalTaxExclrebate.subtract(new BigDecimal(rebateAmount));
			taxAmount  = (totalTaxInclRebate.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN)).intValue();
		}
		else
		{
			Integer taxableAmount = input.get("annualsalary") - taxBracket.getTaxableIncomeMinimumAmountRange();
			System.out.println("TaxableIncomeMinimumAmountRange returned :======> "+taxBracket.getTaxableIncomeMinimumAmountRange());
			System.out.println("taxableAmount returned :======> "+taxableAmount);
			System.out.println("TaxableIncomePercent returned :======> "+taxBracket.getTaxableIncomePercent());
			BigDecimal portionabletaxAmount =  (new BigDecimal (taxableAmount).multiply(taxBracket.getTaxableIncomePercent())); 
			System.out.println("portionabletaxAmount returned :======> "+portionabletaxAmount);
			BigDecimal totalTaxExclrebate = portionabletaxAmount.add(new BigDecimal(taxBracket.getDefaultTaxAmount()));
			System.out.println("DefaultTaxAmount returned :======> "+taxBracket.getDefaultTaxAmount());
			BigDecimal totalTaxInclRebate = totalTaxExclrebate.subtract(new BigDecimal(rebateAmount));
			taxAmount  = (totalTaxInclRebate.divide(new BigDecimal(12), BigDecimal.ROUND_HALF_DOWN)).intValue();
		}
		return taxAmount;
	}
	
	private TaxTable getTaxBracket(Integer year, Integer salary) {
		
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
	
	private HashMap<String,Integer> getInput() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("annualsalary", 500000);
		map.put("age", 50);
		map.put("taxyear", 2021);
		map.put("dependents",2);
		return map;
	}
}
