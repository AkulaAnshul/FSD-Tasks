package com.example.UseCase3;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();

                    Book book = new Book(
                            id,
                            title,
                            author,
                            category,
                            price,
                            copies
                    );

                    dao.saveBook(book);

                    System.out.println("Book Added Successfully!");
                    break;

                case 2:

                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();

                    Book foundBook = dao.getBook(searchId);

                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Book updateBook = dao.getBook(updateId);

                    if (updateBook != null) {

                        System.out.print("Enter New Title: ");
                        updateBook.setTitle(sc.nextLine());

                        System.out.print("Enter New Author: ");
                        updateBook.setAuthor(sc.nextLine());

                        System.out.print("Enter New Category: ");
                        updateBook.setCategory(sc.nextLine());

                        System.out.print("Enter New Price: ");
                        updateBook.setPrice(sc.nextDouble());

                        System.out.print("Enter New Available Copies: ");
                        updateBook.setAvailableCopies(sc.nextInt());

                        dao.updateBook(updateBook);

                        System.out.println("Book Updated Successfully!");
                    } else {
                        System.out.println("Book Not Found!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Book ID to Delete: ");
                    int deleteId = sc.nextInt();

                    dao.deleteBook(deleteId);

                    System.out.println("Delete Operation Completed!");
                    break;

                case 5:

                    List<Book> books = dao.getAllBooks();

                    if (books.isEmpty()) {
                        System.out.println("No Books Found!");
                    } else {

                        System.out.println("\n===== BOOK LIST =====");

                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }

                    break;

                case 6:

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