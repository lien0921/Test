package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mycompany.bean.EmployeeInfoBean;
import com.mycompany.dao.DepartementDAO;
import com.mycompany.dao.EmployeeDAO;
import com.mycompany.entity.Departement;
import com.mycompany.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Autowired
	private DepartementService departementService;
	
	public EmployeeInfoBean findEmpAll(String page){
		
		Integer pc = new Integer(page);
		Sort sort = new Sort(Direction.DESC, "empId");
	    Pageable pageable = new PageRequest(pc, 10, sort); 
		
		Page<Employee> ptbus =  employeeDAO.findAll(pageable);
		
		EmployeeInfoBean empInfo = new EmployeeInfoBean();
		empInfo.setEmployees(ptbus.getContent());
		empInfo.setPage(ptbus.getTotalPages());
		empInfo.setNextPage(ptbus.getNumber()+1);
		empInfo.setPrePage(ptbus.getNumber()+2);
		
		return empInfo;
	}
	
	/**
	 * 姓名、員工編號、年齡、部門名稱
	 * @param eid
	 */
	public EmployeeInfoBean queryBycondition(String page,final String empId ,final String name, final int age,final String dname) {
		
		Integer pc = new Integer(page);
		Sort sort = new Sort(Direction.DESC, "empId");
	    Pageable pageable = new PageRequest(pc, 10, sort); 
		
	    
	    Page<Employee> ptbus = employeeDAO.findAll(new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				if (!StringUtils.isEmpty(empId)) {
					predicates.add(cb.equal(root.get("empId"), empId));
	            }
				
				if (!StringUtils.isEmpty(name)) {
					predicates.add(cb.equal(root.get("name"), name));
	            }
				
				if (0 < age) {
					predicates.add(cb.equal(root.get("age"), age));
	            }
				
				if(!StringUtils.isEmpty(dname)) {
					Departement dep =  departementService.findByName(dname);
					if(null != dep) {
						predicates.add(cb.equal(root.get("depId"), dep.getDepId()));
					}
					
				}
				
				 Predicate[] p = new Predicate[predicates.size()];
		         return cb.and(predicates.toArray(p));
			}
	    },pageable);
	      
	    
	    EmployeeInfoBean empInfo = new EmployeeInfoBean();
		empInfo.setEmployees(ptbus.getContent());
		empInfo.setPage(ptbus.getTotalPages());
		empInfo.setNextPage(ptbus.getNumber()+1);
		empInfo.setPrePage(ptbus.getNumber()+2);
	    
	    return empInfo;
	    
	    
	}
	
	public void addEmp(Employee emp) {
		employeeDAO.save(emp);
	}
	
	public void updateEmp(Employee emp) {
		employeeDAO.save(emp);
		
	}
	
	public void delEmp(String eid) {
		employeeDAO.delete(eid);
	}
}
