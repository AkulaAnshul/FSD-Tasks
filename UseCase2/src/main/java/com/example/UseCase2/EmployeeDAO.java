package com.example.UseCase2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    public void saveEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(employee);

        tx.commit();
        session.close();
    }

    public Employee getEmployee(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = session.get(Employee.class, id);

        session.close();

        return employee;
    }

    public void updateEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(employee);

        tx.commit();
        session.close();
    }

    public void deleteEmployee(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        if(employee != null) {
            session.remove(employee);
        }

        tx.commit();
        session.close();
    }
}