package za.co.labournet.tax;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MedicalTaxCredits {
	
	@Id
	@GeneratedValue
	Long Id;
	int taxCreditAmount;
	int dependantKey;
	Date year;
	
	public MedicalTaxCredits() {}
	
	public MedicalTaxCredits(int taxCreditAmount,int dependantKey,Date year) {
		this.taxCreditAmount = taxCreditAmount;
		this.dependantKey = dependantKey;
		this.year = year;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getTaxCreditAmount() {
		return taxCreditAmount;
	}

	public void setTaxCreditAmount(int taxCreditAmount) {
		this.taxCreditAmount = taxCreditAmount;
	}

	public int getDependantKey() {
		return dependantKey;
	}

	public void setDependantKey(int dependantKey) {
		this.dependantKey = dependantKey;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
	
	
}
