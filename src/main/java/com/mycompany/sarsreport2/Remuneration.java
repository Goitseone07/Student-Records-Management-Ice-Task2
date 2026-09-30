/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sarsreport2;

/**
 *
 * @author emeris
 */
public class Remuneration {
    private double hourlyRate;
    private double normalMonthlyHours;
    private double overtimeRate;

    public Remuneration(double hourlyRate,
                        double normalMonthlyHours) {

        this.hourlyRate = hourlyRate;
        this.normalMonthlyHours = normalMonthlyHours;
        this.overtimeRate = 1.5;
    }

    public double calculateNormalSalary(double hoursWorked) {
        double normalHours = Math.min(
                hoursWorked, normalMonthlyHours);

        return normalHours * hourlyRate;
    }

    public double calculateOvertimeHours(double hoursWorked) {
        if (hoursWorked > normalMonthlyHours) {
            return hoursWorked - normalMonthlyHours;
        } else {
            return 0;
        }
    }

    public double calculateOvertimeSalary(double hoursWorked) {
        double overtimeHours =
                calculateOvertimeHours(hoursWorked);

        return overtimeHours * hourlyRate * overtimeRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getNormalMonthlyHours() {
        return normalMonthlyHours;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }
}
