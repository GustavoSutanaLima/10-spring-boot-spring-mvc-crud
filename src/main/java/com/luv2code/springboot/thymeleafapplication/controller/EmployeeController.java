package com.luv2code.springboot.thymeleafapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafapplication.entity.Employee;
import com.luv2code.springboot.thymeleafapplication.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> listEmployees =  employeeService.findAll();

        model.addAttribute("listEmployees", listEmployees);

        return "employees/employees_list";
    }

    @GetMapping("/new-employee/form")
    public String employeeForm(@ModelAttribute("employee") Employee employee ) {
        return "employees/employee_form";
    }

    @PostMapping("/processed-employee")
    public String addEmployee(@ModelAttribute ("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list"; //redirect chama o método anotado com GetMapping("/employees/list")
    }

    @GetMapping("/show-form-update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);
        //quando o html abaixo é carregado, o thymeleaf irá dar um get em todos os atributos da Classe Employee
        //declarados no html;
        return "employees/employee_form";
    }

    @GetMapping("/delete/employee")
    public String deleteEmployee(@RequestParam("employeeId") int id, Model model){
        
        model.addAttribute("employee", employeeService.findById(id));

        employeeService.deleteById(id);

        return "employees/employee_deleted";
    }


}
