/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sarsreport2;

/**
 *
 * @author emeris
 */
public class Salary {
    private String month;
    private Employee employee;
    private Company company;
    private double hoursWorked;

    private double normalSalary;
    private double overtimeHours;
    private double overtimeSalary;
    private double totalSalary;

    public Salary(String month, Employee employee,
                  Company company, double hoursWorked,
                  Remuneration remuneration) {

        this.month = month;
        this.employee = employee;
        this.company = company;
        this.hoursWorked = hoursWorked;

        normalSalary =
                remuneration.calculateNormalSalary(hoursWorked);

        overtimeHours =
                remuneration.calculateOvertimeHours(hoursWorked);

        overtimeSalary =
                remuneration.calculateOvertimeSalary(hoursWorked);

        totalSalary = normalSalary + overtimeSalary;
    }

    public String getMonth() {
        return month;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getNormalSalary() {
        return normalSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
