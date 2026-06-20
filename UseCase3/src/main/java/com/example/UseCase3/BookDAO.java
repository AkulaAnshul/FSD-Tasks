package com.example.UseCase3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDAO {

    public void saveBook(Book book) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
    }

    public Book getBook(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Book book = session.get(Book.class, id);

        session.close();

        return book;
    }

    public void updateBook(Book book) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(book);

        tx.commit();
        session.close();
    }

    public void deleteBook(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            session.remove(book);
        }

        tx.commit();
        session.close();
    }

    public List<Book> getAllBooks() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Book> books =
                session.createQuery(
                        "from Book",
                        Book.class
                ).list();

        session.close();

        return books;
    }
}