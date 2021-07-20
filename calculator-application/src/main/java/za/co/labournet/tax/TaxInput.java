package za.co.labournet.tax;

public class TaxInput {
	
	String taxYear;
	Integer age;
	Integer totalTaxableIncome;
	Integer medicalAidMembers;
	
	public TaxInput (String taxYear,Integer age,Integer totalTaxableIncome,Integer medicalAidMebers) {
		this.taxYear = taxYear;
		this.age = age;
		this.totalTaxableIncome = totalTaxableIncome;
		this.medicalAidMembers = medicalAidMebers;
	}

	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTotalTaxableIncome() {
		return totalTaxableIncome;
	}

	public void setTotalTaxableIncome(Integer totalTaxableIncome) {
		this.totalTaxableIncome = totalTaxableIncome;
	}

	public Integer getMedicalAidMembers() {
		return medicalAidMembers;
	}

	public void setMedicalAidMembers(Integer medicalAidMebers) {
		this.medicalAidMembers = medicalAidMebers;
	}
	
}
