package za.co.labournet.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MedicalTaxCreditsRunner implements CommandLineRunner {

	private final MedicalAidCreditsRepository repository;
	private List<MedicalTaxCredits> medicalTaxCredits = new ArrayList<MedicalTaxCredits>();
	
	public MedicalTaxCreditsRunner(MedicalAidCreditsRepository repository) {
		
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Calendar taxYear = Calendar.getInstance();
		taxYear.setTimeInMillis(System.currentTimeMillis());
		
		//2020
		int previousYearIntegerValue = taxYear.get(Calendar.YEAR) - 1;
		taxYear.set(Calendar.YEAR, previousYearIntegerValue);
		Date previousYearDateObjectValue = taxYear.getTime();
		
		medicalTaxCredits.add(new MedicalTaxCredits(310,0,previousYearDateObjectValue));
		medicalTaxCredits.add(new MedicalTaxCredits(310,1,previousYearDateObjectValue));
		medicalTaxCredits.add(new MedicalTaxCredits(209,2,previousYearDateObjectValue));
		
		//2021
		int currentIntegerYearvalue = taxYear.get(Calendar.YEAR) + 1;
		taxYear.set(Calendar.YEAR, currentIntegerYearvalue);
		Date currentYearDateObjectValue = taxYear.getTime();
		
		medicalTaxCredits.add(new MedicalTaxCredits(319,0,currentYearDateObjectValue));
		medicalTaxCredits.add(new MedicalTaxCredits(319,1,currentYearDateObjectValue));
		medicalTaxCredits.add(new MedicalTaxCredits(215,2,currentYearDateObjectValue));
		
		repository.saveAll(medicalTaxCredits);
		
	}

}
