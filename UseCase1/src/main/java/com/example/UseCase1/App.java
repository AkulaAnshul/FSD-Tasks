package com.example.UseCase1;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
    	boolean running = true;
        Scanner sc = new Scanner(System.in);
        while(running) {
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
        	switch (choice) {
            case 1:
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Student newStudent = new Student(id, name, email, course, age);

                session1.persist(newStudent);

                tx1.commit();
                session1.close();

                System.out.println("Student inserted successfully!");
                break;

            case 2:
                Session session2 = HibernateUtil.getSessionFactory().openSession();

                System.out.print("Enter Student ID: ");
                int searchId = sc.nextInt();

                Student foundStudent = session2.get(Student.class, searchId);

                if (foundStudent != null) {
                    System.out.println("\nStudent Details");
                    System.out.println("ID: " + foundStudent.getStudentID());
                    System.out.println("Name: " + foundStudent.getStudentName());
                    System.out.println("Email: " + foundStudent.getEmail());
                    System.out.println("Course: " + foundStudent.getCourse());
                    System.out.println("Age: " + foundStudent.getAge());
                } else {
                    System.out.println("Student not found!");
                }

                session2.close();
                break;

            case 3:

                Session session3 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx3 = session3.beginTransaction();

                System.out.print("Enter Student ID to update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Student updateStudent = session3.get(Student.class, updateId);

                if (updateStudent != null) {

                    System.out.print("Enter New Name: ");
                    updateStudent.setStudentName(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    updateStudent.setEmail(sc.nextLine());

                    System.out.print("Enter New Course: ");
                    updateStudent.setCourse(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    updateStudent.setAge(sc.nextInt());

                    session3.merge(updateStudent);

                    tx3.commit();

                    System.out.println("Student updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }

                session3.close();
                break;

            case 4:

                Session session4 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx4 = session4.beginTransaction();

                System.out.print("Enter Student ID to delete: ");
                int deleteId = sc.nextInt();

                Student deleteStudent = session4.get(Student.class, deleteId);

                if (deleteStudent != null) {

                    session4.remove(deleteStudent);

                    tx4.commit();

                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student not found!");
                }

                session4.close();
                break;
            case 5:
            	running = false;
            	break;

            default:
                System.out.println("Invalid choice!");
        	}
        }
       HibernateUtil.getSessionFactory().close();
    }
}