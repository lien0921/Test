package com.mycompany.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.entity.Departement;
import com.mycompany.entity.Employee;

@Repository
public interface DepartementDAO extends CrudRepository<Departement, String>{

	List<Departement> findAll(Specification<Departement> specification);

	
}
