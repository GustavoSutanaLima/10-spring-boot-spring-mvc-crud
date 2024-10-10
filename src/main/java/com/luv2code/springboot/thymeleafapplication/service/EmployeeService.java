package com.luv2code.springboot.thymeleafapplication.service;

import java.util.List;

import com.luv2code.springboot.thymeleafapplication.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
