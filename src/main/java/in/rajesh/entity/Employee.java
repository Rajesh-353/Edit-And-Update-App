package in.rajesh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String empName;
	private String empDept;
	private String empGender;
	private Double empSalary;
	private String activeSwt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}
	

	public String getActiveSwt() {
		return activeSwt;
	}

	public void setActiveSwt(String activeSwt) {
		this.activeSwt = activeSwt;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empDept=" + empDept + ", empGender=" + empGender
				+ ", empSalary=" + empSalary + ", activeSwt=" + activeSwt + "]";
	}
}
