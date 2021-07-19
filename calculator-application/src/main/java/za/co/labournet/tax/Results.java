package za.co.labournet.tax;

public class Results {

	private Integer monthlyTax;
	private Integer annulTax;
	private Integer taxCredit;
	private Integer salaryAfterTax;
	private Integer salaryAfterTaxCredits;
	
	public Results() {
		
	}
	
	public Results(Integer monthlyTax,Integer annulaTax,Integer taxCredit,Integer salaryAfterTax,Integer salaryAfterTaxCredits) {
		this.monthlyTax = monthlyTax;
		this.annulTax = annulaTax;
		this.taxCredit = taxCredit;
		this.salaryAfterTax = salaryAfterTax;
		this.salaryAfterTaxCredits  = salaryAfterTax;
	}

	public Integer getMonthlyTax() {
		return monthlyTax;
	}

	public void setMonthlyTax(Integer monthlyTax) {
		this.monthlyTax = monthlyTax;
	}

	public Integer getAnnulTax() {
		return annulTax;
	}

	public void setAnnulTax(Integer annulTax) {
		this.annulTax = annulTax;
	}

	public Integer getTaxCredit() {
		return taxCredit;
	}

	public void setTaxCredit(Integer taxCredit) {
		this.taxCredit = taxCredit;
	}

	public Integer getSalaryAfterTax() {
		return salaryAfterTax;
	}

	public void setSalaryAfterTax(Integer salaryAfterTax) {
		this.salaryAfterTax = salaryAfterTax;
	}

	public Integer getSalaryAfterTaxCredits() {
		return salaryAfterTaxCredits;
	}

	public void setSalaryAfterTaxCredits(Integer salaryAfterTaxCredits) {
		this.salaryAfterTaxCredits = salaryAfterTaxCredits;
	}
	
	

}
