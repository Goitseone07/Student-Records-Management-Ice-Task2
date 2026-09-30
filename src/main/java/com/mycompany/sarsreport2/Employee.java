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


public class Employee extends Person {
    private String employeeId;
    private String startDate;
    private String endDate;
    private Company company;

    private ArrayList<Salary> salaries;

    public Employee(String employeeId, String name,
                    String surname, String address,
                    String startDate, String endDate,
                    Company company) {

        super(name, surname, address);

        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;

        salaries = new ArrayList<>();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Company getCompany() {
        return company;
    }

    public void addSalary(Salary salary) {
        salaries.add(salary);
    }

    public ArrayList<Salary> getSalaries() {
        return salaries;
    }
}
