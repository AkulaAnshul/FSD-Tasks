package com.example.UseCase2;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("1. Create Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    int salary = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Joining Date: ");
                    String joiningDate = sc.nextLine();

                    Employee emp = new Employee(
                            id,
                            name,
                            dept,
                            salary,
                            joiningDate
                    );

                    dao.saveEmployee(emp);

                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();

                    Employee found = dao.getEmployee(searchId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Employee Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Employee updateEmp = dao.getEmployee(updateId);

                    if (updateEmp != null) {

                        System.out.print("Enter New Name: ");
                        updateEmp.setEmployeeName(sc.nextLine());

                        System.out.print("Enter New Department: ");
                        updateEmp.setDepartment(sc.nextLine());

                        System.out.print("Enter New Salary: ");
                        updateEmp.setSalary(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter New Joining Date: ");
                        updateEmp.setJoiningDate(sc.nextLine());

                        dao.updateEmployee(updateEmp);

                        System.out.println("Employee Updated Successfully!");
                    } else {
                        System.out.println("Employee Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteEmployee(deleteId);

                    System.out.println("Delete Operation Completed!");

                    break;

                case 5:

                    sc.close();
                    HibernateUtil.getSessionFactory().close();

                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}