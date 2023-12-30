package in.rajesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rajesh.entity.Employee;
import in.rajesh.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface{

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> getRecords() {
		List<Employee> list = repo.findByActiveSwt("Y");
		return list;
	}

	
	
	@Override
	public Employee updateRecords( Integer id) {
		Employee employee = repo.findById(id).get();
		return employee;		
	}

	@Override
	public boolean saveRecord(Employee save) {
		Employee employee = repo.save(save);
		if(employee.getId()!=null) {
			return true;
		}
		return false;	
		
	}



	@Override
	public Employee deleteRecords(Integer id) {
		
		 Optional<Employee> list = repo.findById(id);
		 if(list.isPresent()) {
			 Employee emp = list.get();
			 emp.setActiveSwt("N");
			 repo.save(emp);
		 }
		
		return null;
	}

}
