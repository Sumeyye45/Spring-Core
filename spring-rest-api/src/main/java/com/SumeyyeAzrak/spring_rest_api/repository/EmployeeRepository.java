package com.SumeyyeAzrak.spring_rest_api.repository;

import com.SumeyyeAzrak.spring_rest_api.dtos.UpdateEmployeeRequest;
import com.SumeyyeAzrak.spring_rest_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {

        return employeeList;
    }

    public Employee getEmployeeById(String id) {

        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }

        }
        return findEmployee;
    }


    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {

        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }

        for (Employee employee : employeeList) {

            if (firstName != null && lastName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeWithParams.add(employee);
                }
            }
            if (firstName != null && lastName == null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeWithParams.add(employee);
                }
            }
            if (lastName != null && firstName == null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
        }

        return employeeWithParams;
    }

    public Employee saveEmployee(Employee newEmployee) {

        employeeList.add(newEmployee);
        return newEmployee;

    }

    public boolean deleteEmployee(String id) {

        Employee deleteEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                deleteEmployee = employee;
                break;
            }
            if (deleteEmployee == null) {
                return false;
            }
        }
        employeeList.remove(deleteEmployee);
        return true;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request){

        Employee updateEmployee = null;
        for(Employee employee : employeeList){
            if(id.equals(employee.getId())){
                employee.setFirstName(request.getFirstName());
                employee.setLastName(request.getLastName());
                updateEmployee = employee;
                break;
            }
        }


        return updateEmployee;
    }


}
