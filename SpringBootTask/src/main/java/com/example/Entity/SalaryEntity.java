package com.example.Entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="salary")
public class SalaryEntity {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "position_id", nullable = false)
	    private PositionEntity position;

	    @Column(name = "basic_salary", nullable = false)
	    private BigDecimal basicSalary;

	    @Column(name = "hra", nullable = false)
	    private BigDecimal hra;

	    @Column(name = "da", nullable = false)
	    private BigDecimal da;

	    @Column(name = "other_allowances", nullable = false)
	    private BigDecimal otherAllowances;

	    @Column(name = "gross_salary", nullable = false)
	    private BigDecimal grossSalary;

	    @Column(name = "created_at", nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdAt;

	    @Column(name = "updated_at", nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date updatedAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public PositionEntity getPosition() {
			return position;
		}

		public void setPosition(PositionEntity position) {
			this.position = position;
		}

		public BigDecimal getBasicSalary() {
			return basicSalary;
		}

		public void setBasicSalary(BigDecimal basicSalary) {
			this.basicSalary = basicSalary;
		}

		public BigDecimal getHra() {
			return hra;
		}

		public void setHra(BigDecimal hra) {
			this.hra = hra;
		}

		public BigDecimal getDa() {
			return da;
		}

		public void setDa(BigDecimal da) {
			this.da = da;
		}

		public BigDecimal getOtherAllowances() {
			return otherAllowances;
		}

		public void setOtherAllowances(BigDecimal otherAllowances) {
			this.otherAllowances = otherAllowances;
		}

		public BigDecimal getGrossSalary() {
			return grossSalary;
		}

		public void setGrossSalary(BigDecimal grossSalary) {
			this.grossSalary = grossSalary;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "SalaryEntity [id=" + id + ", position=" + position + ", basicSalary=" + basicSalary + ", hra=" + hra
					+ ", da=" + da + ", otherAllowances=" + otherAllowances + ", grossSalary=" + grossSalary
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
		}
	    
	    
	    
}
