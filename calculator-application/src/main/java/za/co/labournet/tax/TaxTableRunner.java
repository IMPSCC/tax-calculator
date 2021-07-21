package za.co.labournet.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class TaxTableRunner implements CommandLineRunner {

	private final TaxTableRepository repository;
	
	public TaxTableRunner(TaxTableRepository repository) {
		this.repository = repository;
	}
	
	
	//(Date taxYear, BigDecimal taxableIncomePercent, Integer taxableIncomeMinimumAmountRange,Integer taxableIncomeMaximumAmountRange,Integer defaultTaxAmount) 
	@Override
	public void run(String... args) throws Exception {
		
		List<TaxTable> taxTableRecords = new ArrayList<TaxTable>();
		
		Calendar taxYear = Calendar.getInstance();
		taxYear.setTimeInMillis(System.currentTimeMillis());
		
		//2020
		
		int previousYearIntegerValue = taxYear.get(Calendar.YEAR) - 1;
		taxYear.set(Calendar.YEAR, previousYearIntegerValue);
		Date previousYearDateObjectValue = taxYear.getTime();
		
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.18),0, 195850, 0));
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.26),195851, 305850, 32253));
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.31),305851, 423300, 63853));
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.36),423301, 555600, 100263));
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.39),555601, 708310, 147891));
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.41),708311, 1500000, 207448));
		taxTableRecords.add(new TaxTable(previousYearDateObjectValue, new BigDecimal(0.45),1500001, 0, 532041));
		
		//2021
		
		int currentIntegerYearvalue = taxYear.get(Calendar.YEAR) + 1;
		taxYear.set(Calendar.YEAR, currentIntegerYearvalue);
		Date currentYearDateObjectValue = taxYear.getTime();
		
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.18),0, 205900, 0));
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.26),205901, 321600, 37062));
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.31),321601, 445100, 67144));
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.36),445101, 584200, 105429));
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.39),584201, 744800, 155505));
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.41),744801, 1577300, 218139));
		taxTableRecords.add(new TaxTable(currentYearDateObjectValue, new BigDecimal(0.45),1577301, 0, 559464));
		
		repository.saveAll(taxTableRecords);
	}

}
