package com.mytest.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mytest.entity.Departement;



@Repository
public interface DepartementDAO extends CrudRepository<Departement, String>{
	List<Departement> findAll(Specification<Departement> specification);
}
