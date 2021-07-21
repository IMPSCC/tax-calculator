package za.co.labournet.tax;

public class TaxTableResults {
	
	
	private String taxYear;
	private String taxableIncomeRange;
	private String rateOfTaxDescription;
	
	private final static String taxableIncomeString = " of taxable income ";
	private final static String aboveString = " above ";
	
	public TaxTableResults(String taxYear,String taxableIncomeRange,String rateOfTaxDescription) {
		
		this.taxYear = taxYear;
		this.taxableIncomeRange = taxableIncomeRange;
		this.rateOfTaxDescription = rateOfTaxDescription;
	}

	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}

	public String getTaxableIncomeRange() {
		return taxableIncomeRange;
	}

	public void setTaxableIncomeRange(String taxableIncomeRange) {
		this.taxableIncomeRange = taxableIncomeRange;
	}

	public String getRateOfTaxDescription() {
		return rateOfTaxDescription;
	}

	public void setRateOfTaxDescription(String rateOfTaxDescription) {
		this.rateOfTaxDescription = rateOfTaxDescription;
	}

	public static String getTaxableIncomeString() {
		return taxableIncomeString;
	}

	public static String getAboveString() {
		return aboveString;
	}

}
