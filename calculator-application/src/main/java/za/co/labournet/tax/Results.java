package za.co.labournet.tax;

public class Results {

	private Integer monthlyTax;
	private Integer annulTax;
	private Integer monthlyTaxCredit;
	private Integer monthlySalaryAfterTax;
	private Integer monthlySalaryAfterTaxCredits;
	
	public Results() {
		
	}
	
	public Results(Integer monthlyTax,Integer annulaTax,Integer monthlyTaxCredit,Integer monthlySalaryAfterTax,Integer monthlySalaryAfterTaxCredits) {
		this.monthlyTax = monthlyTax;
		this.annulTax = annulaTax;
		this.monthlyTaxCredit = monthlyTaxCredit;
		this.monthlySalaryAfterTax = monthlySalaryAfterTax;
		this.monthlySalaryAfterTaxCredits  = monthlySalaryAfterTaxCredits;
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

	public Integer getMonthlyTaxCredit() {
		return monthlyTaxCredit;
	}

	public void setMonthlyTaxCredit(Integer monthlyTaxCredit) {
		this.monthlyTaxCredit = monthlyTaxCredit;
	}

	public Integer getMonthlySalaryAfterTax() {
		return monthlySalaryAfterTax;
	}

	public void setMonthlySalaryAfterTax(Integer monthlySalaryAfterTax) {
		this.monthlySalaryAfterTax = monthlySalaryAfterTax;
	}

	public Integer getMonthlySalaryAfterTaxCredits() {
		return monthlySalaryAfterTaxCredits;
	}

	public void setMonthlySalaryAfterTaxCredits(Integer monthlySalaryAfterTaxCredits) {
		this.monthlySalaryAfterTaxCredits = monthlySalaryAfterTaxCredits;
	}
	
	
	
}
