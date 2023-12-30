package in.rajesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import in.rajesh.entity.Employee;
import in.rajesh.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	public EmployeeController() {
		System.out.println("Employee Controller constructor");
	}

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/get")
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView();
		List<Employee> list = service.getRecords();
		mav.addObject("records", list);
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("/form")
	public ModelAndView empForm() {
		ModelAndView mav = new ModelAndView("empForm");
		mav.addObject("emp", new Employee());
		return mav;

	}

	

	@PostMapping("/emp")
	public ModelAndView saveEmp(@ModelAttribute("emp") Employee emp) {

		ModelAndView mav = new ModelAndView();
		emp.setActiveSwt("y");
		boolean saveRecord = service.saveRecord(emp);
		if (saveRecord) {
			mav.addObject("success", "record is saved");
		} else {
			mav.addObject("err", "failed to save");
		}

		mav.setViewName("empForm");
		return mav;

	}

	@GetMapping("/delete")
	public ModelAndView ModelAndView(@RequestParam("id") Integer id) {

		ModelAndView mav=new ModelAndView("index");
		service.deleteRecords(id);
		List<Employee> list = service.getRecords();
		mav.addObject("records", list);
		service.deleteRecords(id);
		return mav;

	}

	@GetMapping("/update")
	public ModelAndView updateForm(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("updateForm");
		Employee emp = service.updateRecords(id);
		mav.addObject("emp", emp);
		return mav;

	}

	@PostMapping("/updateSave")
	public ModelAndView update(@ModelAttribute("emp") Employee emp) {
		ModelAndView mav=new ModelAndView("updateForm");
	
		boolean flag = service.saveRecord(emp);
		if(flag) {
			mav.addObject("updated", "record is updated");
		}
       
		
		return mav;
	}

}
