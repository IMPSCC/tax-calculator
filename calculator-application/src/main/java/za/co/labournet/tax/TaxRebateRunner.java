package za.co.labournet.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TaxRebateRunner implements CommandLineRunner {

	private final RebateRepository repository;
	private List<TaxRebate> rebates = new ArrayList<TaxRebate>();
	
	public TaxRebateRunner(RebateRepository repository) {
		
		this.repository = repository;
	}
	//(Date taxYear,Integer minimumAge,Integer maximumAge,BigDecimal rebateAmount)
	@Override
	public void run(String... args) throws Exception {
		
		//year 2020
		Calendar taxYear = Calendar.getInstance();
		taxYear.setTimeInMillis(System.currentTimeMillis());
		
		int previousYearIntegerValue = taxYear.get(Calendar.YEAR) - 1;
		taxYear.set(Calendar.YEAR, previousYearIntegerValue);
		Date previousYearDateObjectValue = taxYear.getTime();
		
		//primary
		rebates.add(new TaxRebate(previousYearDateObjectValue,0,64,new BigDecimal(14220)));
		//secondary
		rebates.add(new TaxRebate(previousYearDateObjectValue,65,74,new BigDecimal(22014)));
		//Tertiary
		rebates.add(new TaxRebate(previousYearDateObjectValue,75,1000,new BigDecimal(24615)));
		
		//year 2021
		int currentYearIntegerValue = taxYear.get(Calendar.YEAR) + 1;
		taxYear.set(Calendar.YEAR, currentYearIntegerValue);
		Date currentYearDateObjectValue = taxYear.getTime();
		
		//primary
		rebates.add(new TaxRebate(currentYearDateObjectValue,0,64,new BigDecimal(14958)));
		//secondary
		rebates.add(new TaxRebate(currentYearDateObjectValue,65,74,new BigDecimal(23157)));
		//Tertiary
		rebates.add(new TaxRebate(currentYearDateObjectValue,75,1000,new BigDecimal(25893)));
		repository.saveAll(rebates);
		repository.findAll().forEach(System.out::println);
		
	}

}
