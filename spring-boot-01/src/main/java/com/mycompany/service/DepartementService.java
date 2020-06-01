package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mycompany.dao.DepartementDAO;
import com.mycompany.entity.Departement;

@Service
public class DepartementService {

	@Autowired
	DepartementDAO departementDAO;
	
	public List<Departement> findDepAll(){
		List<Departement> emps = (List<Departement>) departementDAO.findAll();
		return emps;
	}
	
	public Departement findByName(final String name) {
		
		List<Departement> deps = departementDAO.findAll(new Specification<Departement>() {

			@Override
			public Predicate toPredicate(Root<Departement> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<Predicate>();
				
				if (null != name) {
					predicates.add(cb.equal(root.get("dName"), name));
	            }
				
				 Predicate[] p = new Predicate[predicates.size()];
		         return cb.and(predicates.toArray(p));
			}
	    });
		
		if(null != deps && deps.size()>0) {
			return deps.get(0);
		}
		
		return null;
	}
	
	public void addDep(Departement dep) {
		departementDAO.save(dep);
	}
	
	public void updateDep(Departement emp) {
		departementDAO.save(emp);
		
	}
	
	public void delDep(String did) {
		departementDAO.delete(did);
	}
	
}
