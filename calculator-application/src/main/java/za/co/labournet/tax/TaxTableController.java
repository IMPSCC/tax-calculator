package za.co.labournet.tax;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/taxtable")
public class TaxTableController {

	
	private TaxTableRepository taxRepository;
	public TaxTableController (TaxTableRepository taxRepository) {
		this.taxRepository = taxRepository;
	}
	
	@PostMapping
	public List<TaxTableResults> getTaxTableByYear(@RequestBody String taxYear){
		
		return getTaxTable().get(taxYear);
	}
	
	
	private HashMap<String,List<TaxTableResults>> getTaxTable() {
		
		HashMap<String,List<TaxTableResults>> mappingByYear = new HashMap<String,List<TaxTableResults>>();
		TaxTableResults taxObjectHolder = null;
		List<TaxTableResults> taxObjectHolderList = null;
		
		for(TaxTable item : taxRepository.findAll()) {
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(item.getTaxYear());
			
			StringBuffer rateOftaxDescription = null;
			StringBuffer taxableIncomeRangeDescription = new StringBuffer(item.getTaxableIncomeMinimumAmountRange().toString()).append(" - ").append(item.getTaxableIncomeMaximumAmountRange());
			
			String percentAmount = item.getTaxableIncomePercent().toString();
			
			if(item.getDefaultTaxAmount() > 0) 
			{
				rateOftaxDescription = new StringBuffer(item.getDefaultTaxAmount().toString()).append(" + ").append(percentAmount.substring(percentAmount.indexOf(".")+1)).append("%").append(TaxTableResults.getTaxableIncomeString()).append(TaxTableResults.getAboveString()).append(item.getTaxableIncomeMinimumAmountRange());
			}
			else
			{
				rateOftaxDescription = new StringBuffer(percentAmount.substring(percentAmount.indexOf(".")+1)).append("%").append(TaxTableResults.getTaxableIncomeString());
			}
			
			if(!mappingByYear.containsKey(String.valueOf(calendar.get(Calendar.YEAR)))) 
			{
				taxObjectHolderList = new ArrayList<TaxTableResults>();
				
				taxObjectHolder = new TaxTableResults(String.valueOf(calendar.get(Calendar.YEAR)),taxableIncomeRangeDescription.toString(),rateOftaxDescription.toString()) ;
				taxObjectHolderList.add(taxObjectHolder);
				mappingByYear.put(String.valueOf(calendar.get(Calendar.YEAR)),taxObjectHolderList);
			}
			else 
			{
				taxObjectHolderList = mappingByYear.get(String.valueOf(calendar.get(Calendar.YEAR)));
				taxObjectHolderList.add(new TaxTableResults(String.valueOf(calendar.get(Calendar.YEAR)),taxableIncomeRangeDescription.toString(),rateOftaxDescription.toString()) );
			}
		}
		return mappingByYear;
	}
}
