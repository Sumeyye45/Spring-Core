package com.SumeyyeAzrak.spring_rest_api.config;

import com.SumeyyeAzrak.spring_rest_api.model.Employee;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Sumeyye", "Azrak" ));
        employeeList.add(new Employee("2", "Aysel", "Azrak" ));
        employeeList.add(new Employee("3", "Ali", "Azrak" ));
        employeeList.add(new Employee("4", "Akif", "Azrak" ));
        employeeList.add(new Employee("5", "Akif", "Kaya" ));
        employeeList.add(new Employee("6", "Akif", "Azrak" ));


        return employeeList;
    }
}
