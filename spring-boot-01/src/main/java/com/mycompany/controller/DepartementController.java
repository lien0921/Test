package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.entity.Departement;
import com.mycompany.service.DepartementService;

@RestController
public class DepartementController {
	
	@Autowired
	DepartementService departementService; 

	@RequestMapping("/dep")
	public List<Departement> findEmpAll() {
		return departementService.findDepAll();
	}
	
	@RequestMapping("/dep/add")
	public String addEmp(@RequestBody Departement dep) {
		departementService.addDep(dep);
		return "success";
	}
	
	@RequestMapping("/dep/update")
	public String updateEmp(@RequestBody Departement dep) {
		departementService.updateDep(dep);
		return "success";
	}
	
	@RequestMapping("/dep/del")
	public String delEmp(@RequestParam("did") String did) {
		departementService.delDep(did);
		return "success";
	}
	
}
