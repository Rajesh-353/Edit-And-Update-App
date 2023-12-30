package in.rajesh.service;

import java.util.List;

import in.rajesh.entity.Employee;

public interface EmployeeServiceInterface {
	
	public boolean saveRecord(Employee emp);
	public List<Employee> getRecords();
	public Employee deleteRecords(Integer id);
	public Employee updateRecords(Integer id);
	
	

}
