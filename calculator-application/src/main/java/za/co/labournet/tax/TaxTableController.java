package za.co.labournet.tax;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/taxtables")
public class TaxTableController {

	
	private TaxTableRepository taxRepository;
	public TaxTableController (TaxTableRepository taxRepository) {
		this.taxRepository = taxRepository;
	}
	
	@GetMapping
	public HashMap<String,List<TaxTableResults>> getTaxTable() {
		
		HashMap<String,List<TaxTableResults>> mappingByYear = new HashMap<String,List<TaxTableResults>>();
		TaxTableResults taxObjectHolder = null;
		List<TaxTableResults> taxObjectHolderList = null;
		
		for(TaxTable item : taxRepository.findAll()) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(item.getTaxYear());
			
			if(!mappingByYear.containsKey(String.valueOf(calendar.get(Calendar.YEAR)))) 
			{
				taxObjectHolderList = new ArrayList<TaxTableResults>();
				taxObjectHolder = new TaxTableResults(String.valueOf(calendar.get(Calendar.YEAR)), String.valueOf(item.getTaxableIncomePercent()),String.valueOf( item.getTaxableIncomeMinimumAmountRange()), String.valueOf(item.getTaxableIncomeMaximumAmountRange()),String.valueOf( item.getDefaultTaxAmount()));
				taxObjectHolderList.add(taxObjectHolder);
				mappingByYear.put(String.valueOf(calendar.get(Calendar.YEAR)),taxObjectHolderList);
			}
			else 
			{
				taxObjectHolderList = mappingByYear.get(String.valueOf(calendar.get(Calendar.YEAR)));
				taxObjectHolderList.add(new TaxTableResults(String.valueOf(calendar.get(Calendar.YEAR)), String.valueOf(item.getTaxableIncomePercent()),String.valueOf( item.getTaxableIncomeMinimumAmountRange()), String.valueOf(item.getTaxableIncomeMaximumAmountRange()),String.valueOf( item.getDefaultTaxAmount())));
			}
		}
		return mappingByYear;
	}
}
