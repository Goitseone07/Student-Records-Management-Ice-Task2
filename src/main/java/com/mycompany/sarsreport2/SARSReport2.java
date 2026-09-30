/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sarsreport2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emeris
 */
public class SARSReport2 {

    public static void main(String[] args) {
        

        Scanner input = new Scanner(System.in);

        ArrayList<Company> companies = new ArrayList<>();

        String[] months = {
            "January", "February", "March",
            "April", "May", "June"
        };

        System.out.println("==================================");
        System.out.println(" SIX-MONTH REMUNERATION REPORT");
        System.out.println("==================================");

        System.out.print("Enter number of companies: ");
        int numberOfCompanies = input.nextInt();
        input.nextLine();

        for (int c = 0; c < numberOfCompanies; c++) {

            System.out.println("\nEnter Company Details");

            System.out.print("Company ID: ");
            String companyId = input.nextLine();

            System.out.print("Company Name: ");
            String companyName = input.nextLine();

            System.out.print("Company Location: ");
            String location = input.nextLine();

            Company company =
                    new Company(companyId, companyName, location);

            companies.add(company);

            System.out.print("Enter number of employees: ");
            int numberOfEmployees = input.nextInt();
            input.nextLine();

            for (int e = 0; e < numberOfEmployees; e++) {

                System.out.println("\nEnter Employee Details");

                System.out.print("Employee ID: ");
                String employeeId = input.nextLine();

                System.out.print("First Name: ");
                String name = input.nextLine();

                System.out.print("Surname: ");
                String surname = input.nextLine();

                System.out.print("Address: ");
                String address = input.nextLine();

                System.out.print("Employment Start Date: ");
                String startDate = input.nextLine();

                System.out.print("Employment End Date: ");
                String endDate = input.nextLine();

                Employee employee = new Employee(
                        employeeId, name, surname, address,
                        startDate, endDate, company);

                company.addEmployee(employee);

                System.out.print("Hourly Rate (R): ");
                double hourlyRate = input.nextDouble();

                System.out.print("Normal Monthly Hours: ");
                double normalHours = input.nextDouble();
                input.nextLine();

                Remuneration remuneration =
                        new Remuneration(hourlyRate, normalHours);

                System.out.println(
                        "\nEnter hours worked for six months:");

                for (int m = 0; m < 6; m++) {

                    System.out.print(months[m] + ": ");
                    double hoursWorked = input.nextDouble();

                    Salary salary = new Salary(
                            months[m], employee, company,
                            hoursWorked, remuneration);

                    employee.addSalary(salary);
                }

                input.nextLine();
            }
        }

        // Generate reports
        for (Company company : companies) {

            System.out.println("\n\n==================================");
            System.out.println("COMPANY: " + company.getCompanyName());
            System.out.println("COMPANY ID: " + company.getCompanyId());
            System.out.println("LOCATION: " + company.getLocation());
            System.out.println("==================================");

            for (Employee employee : company.getEmployees()) {

                System.out.println("\n----------------------------------");
                System.out.println("SIX-MONTH SARS REMUNERATION REPORT");
                System.out.println("----------------------------------");

                System.out.println("Employee ID: "
                        + employee.getEmployeeId());

                System.out.println("Employee Name: "
                        + employee.getName() + " "
                        + employee.getSurname());

                System.out.println("Address: "
                        + employee.getAddress());

                System.out.println("Employment Start Date: "
                        + employee.getStartDate());

                System.out.println("Employment End Date: "
                        + employee.getEndDate());

                System.out.println("\n"
                        + String.format("%-12s %12s %12s %15s %15s",
                        "Month", "Normal (R)", "OT Hours",
                        "OT Earnings", "Total (R)"));

                System.out.println(
                        "--------------------------------------------------------------------------");

                double totalNormalSalary = 0;
                double totalOvertimeHours = 0;
                double totalOvertimeSalary = 0;
                double totalGrossSalary = 0;

                boolean workedOvertime = false;

                for (Salary salary : employee.getSalaries()) {

                    System.out.printf(
                            "%-12s %12.2f %12.2f %15.2f %15.2f%n",
                            salary.getMonth(),
                            salary.getNormalSalary(),
                            salary.getOvertimeHours(),
                            salary.getOvertimeSalary(),
                            salary.getTotalSalary()
                    );

                    totalNormalSalary += salary.getNormalSalary();
                    totalOvertimeHours += salary.getOvertimeHours();
                    totalOvertimeSalary += salary.getOvertimeSalary();
                    totalGrossSalary += salary.getTotalSalary();

                    if (salary.getOvertimeHours() > 0) {
                        workedOvertime = true;
                    }
                }

                System.out.println(
                        "--------------------------------------------------------------------------");

                System.out.printf("Total Normal Salary: R%.2f%n",
                        totalNormalSalary);

                System.out.printf("Total Overtime Hours: %.2f%n",
                        totalOvertimeHours);

                System.out.printf("Total Overtime Earnings: R%.2f%n",
                        totalOvertimeSalary);

                System.out.printf("Total Gross Salary: R%.2f%n",
                        totalGrossSalary);

                if (workedOvertime) {
                    System.out.println(
                            "Worked Overtime: Yes");
                } else {
                    System.out.println(
                            "Worked Overtime: No");
                }
            }
        }

        input.close();
    }
}
    

