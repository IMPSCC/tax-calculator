package za.co.labournet.tax;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TaxTable
 *
 */
@Entity
public class TaxTable implements Serializable {

	@Id
	@GeneratedValue
	private Long Id;
	private Date taxYear;
	private BigDecimal taxableIncomePercent;
	private Integer taxableIncomeMinimumAmountRange;
	private Integer taxableIncomeMaximumAmountRange;
	private Integer defaultTaxAmount;
	
	public TaxTable() {}
	
	public TaxTable(Date taxYear, BigDecimal taxableIncomePercent, Integer taxableIncomeMinimumAmountRange,Integer taxableIncomeMaximumAmountRange,Integer defaultTaxAmount) {
		
		this.taxYear = taxYear;
		this.taxableIncomePercent = taxableIncomePercent;
		this.taxableIncomeMinimumAmountRange = taxableIncomeMinimumAmountRange;
		this.taxableIncomeMaximumAmountRange = taxableIncomeMaximumAmountRange;
		this.defaultTaxAmount = defaultTaxAmount;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(Date taxYear) {
		this.taxYear = taxYear;
	}

	public BigDecimal getTaxableIncomePercent() {
		return taxableIncomePercent;
	}

	public void setTaxableIncomePercent(BigDecimal taxableIncomePercent) {
		this.taxableIncomePercent = taxableIncomePercent;
	}

	public Integer getTaxableIncomeMinimumAmountRange() {
		return taxableIncomeMinimumAmountRange;
	}

	public void setTaxableIncomeMinimumAmountRange(Integer taxableIncomeMinimumAmountRange) {
		this.taxableIncomeMinimumAmountRange = taxableIncomeMinimumAmountRange;
	}

	public Integer getTaxableIncomeMaximumAmountRange() {
		return taxableIncomeMaximumAmountRange;
	}

	public void setTaxableIncomeMaximumAmountRange(Integer taxableIncomeMaximumAmountRange) {
		this.taxableIncomeMaximumAmountRange = taxableIncomeMaximumAmountRange;
	}

	public Integer getDefaultTaxAmount() {
		return defaultTaxAmount;
	}

	public void setDefaultTaxAmount(Integer defaultTaxAmount) {
		this.defaultTaxAmount = defaultTaxAmount;
	}
	
	
	
}
