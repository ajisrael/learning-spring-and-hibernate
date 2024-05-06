package com.ajisrael.cruddemo.dao;

import com.ajisrael.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
