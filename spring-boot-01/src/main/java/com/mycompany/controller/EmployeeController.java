package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.bean.EmployeeInfoBean;
import com.mycompany.entity.Employee;
import com.mycompany.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emp/{page}")
	public EmployeeInfoBean findEmpAll(@PathVariable("page") String page) {
		return employeeService.findEmpAll(page);
	}
	
	@RequestMapping("/emp/query")
	public EmployeeInfoBean findEmpByCondition(@RequestParam("page") String page ,
			                                   @RequestParam(value="eid",required=false) String eid,
			                                   @RequestParam(value="name",required=false) String name,
			                                   @RequestParam(value="age",required=false)int age,
			                                   @RequestParam(value="dname",required=false) String dname) {
		return employeeService.queryBycondition(page, eid,name , age,dname);
	}
	
	@RequestMapping("/emp/add")
	public String addEmp(@RequestBody Employee emp) {
		employeeService.addEmp(emp);
		return "success";
	}
	
	@RequestMapping("/emp/update")
	public String updateEmp(@RequestBody Employee emp) {
		employeeService.updateEmp(emp);
		return "success";
	}
	
	@RequestMapping("/emp/del")
	public String delEmp(@RequestParam("eid") String eid) {
		employeeService.delEmp(eid);
		return "success";
	}
	
}
