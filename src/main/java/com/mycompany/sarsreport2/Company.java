/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sarsreport2;
import java.util.ArrayList;
/**
 *
 * @author emeris
 */
public class Company {
    private String companyId;
    private String companyName;
    private String location;

    private ArrayList<Employee> employees;

    public Company(String companyId, String companyName,
                   String location) {

        this.companyId = companyId;
        this.companyName = companyName;
        this.location = location;

        employees = new ArrayList<>();
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
