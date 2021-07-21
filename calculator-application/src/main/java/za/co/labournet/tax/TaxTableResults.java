package za.co.labournet.tax;

public class TaxTableResults {
	
	private String taxYear;
	private String taxableIncomePercent;
	private String taxableIncomeMinimumAmountRange;
	private String taxableIncomeMaximumAmountRange;
	private String defaultTaxAmount;
	
	public TaxTableResults(String taxYear,String taxableIncomePercent,String taxableIncomeMinimumAmountRange,String taxableIncomeMaximumAmountRange,String defaultTaxAmount) {
		
		this.taxYear = taxYear;
		this.taxableIncomePercent = taxableIncomePercent;
		this.taxableIncomeMinimumAmountRange = taxableIncomeMinimumAmountRange;
		this.taxableIncomeMaximumAmountRange = taxableIncomeMaximumAmountRange;
		this.defaultTaxAmount = defaultTaxAmount;
	}

	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}

	public String getTaxableIncomePercent() {
		return taxableIncomePercent;
	}

	public void setTaxableIncomePercent(String taxableIncomePercent) {
		this.taxableIncomePercent = taxableIncomePercent;
	}

	public String getTaxableIncomeMinimumAmountRange() {
		return taxableIncomeMinimumAmountRange;
	}

	public void setTaxableIncomeMinimumAmountRange(String taxableIncomeMinimumAmountRange) {
		this.taxableIncomeMinimumAmountRange = taxableIncomeMinimumAmountRange;
	}

	public String getTaxableIncomeMaximumAmountRange() {
		return taxableIncomeMaximumAmountRange;
	}

	public void setTaxableIncomeMaximumAmountRange(String taxableIncomeMaximumAmountRange) {
		this.taxableIncomeMaximumAmountRange = taxableIncomeMaximumAmountRange;
	}

	public String getDefaultTaxAmount() {
		return defaultTaxAmount;
	}

	public void setDefaultTaxAmount(String defaultTaxAmount) {
		this.defaultTaxAmount = defaultTaxAmount;
	}

	
}
