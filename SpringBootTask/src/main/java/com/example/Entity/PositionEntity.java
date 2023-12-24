package com.example.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="positions")
@AllArgsConstructor
@NoArgsConstructor
public class PositionEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "department_id", nullable = false)
	    @ManyToOne
	    @JoinColumn(name = "department_id", nullable = false)
	    private Long departmentId;

	    @Column(name = "name", nullable = false)
	    private String name;

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

		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
			return "PositionEntity [id=" + id + ", departmentId=" + departmentId + ", name=" + name + ", createdAt="
					+ createdAt + ", updatedAt=" + updatedAt + "]";
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
