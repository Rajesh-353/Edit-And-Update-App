package in.rajesh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rajesh.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByActiveSwt(String s);
		
	
	

}
