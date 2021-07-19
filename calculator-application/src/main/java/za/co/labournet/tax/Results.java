package za.co.labournet.tax;

public class Results {

	private Integer monthlyTax;
	private Integer annulTax;
	private Integer taxCredit;
	private Integer salaryAfterTax;
	private Integer salaryAftertaxCredits;
	
	public Results() {
		
	}
	
	public Results(Integer monthlyTax,Integer annulaTax) {
		this.monthlyTax = monthlyTax;
		this.annulTax = annulaTax;
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

}
