package com.ajisrael.cruddemo.dao;

import com.ajisrael.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
// Use the below line if you want to change the name of the resource in the rest endpoint path
//@RepositoryRestResource(path="members")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
}
