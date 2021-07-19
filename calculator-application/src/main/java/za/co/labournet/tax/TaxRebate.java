package za.co.labournet.tax;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TaxRebate
 *
 */
@Entity
public class TaxRebate implements Serializable {
	
	@Id
	@GeneratedValue
	private Long Id;
	private Date taxYear;
	private Integer minimumAge;
	private Integer maximumAge;
	private BigDecimal rebateAmount;
	
	public TaxRebate() {}
	
	public TaxRebate(Date taxYear,Integer minimumAge,Integer maximumAge,BigDecimal rebateAmount) {
		this.taxYear = taxYear;
		this.minimumAge = minimumAge;
		this.maximumAge = maximumAge;
		this.rebateAmount = rebateAmount;
		
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

	public Integer getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}

	public Integer getMaximumAge() {
		return maximumAge;
	}

	public void setMaximumAge(Integer maximumAge) {
		this.maximumAge = maximumAge;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("[ year : rebate amount : +]").toString();
	}
	
}
