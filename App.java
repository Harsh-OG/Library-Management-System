package com.jdbcconnectivity.LibraryManagement;

import com.jdbcconnectivity.LibraryManagement.model.Book;
import com.jdbcconnectivity.LibraryManagement.model.Member;
import com.jdbcconnectivity.LibraryManagement.model.Issue;
import com.jdbcconnectivity.LibraryManagement.service.BookService;
import com.jdbcconnectivity.LibraryManagement.service.MemberService;
import com.jdbcconnectivity.LibraryManagement.service.IssueService;
import com.jdbcconnectivity.LibraryManagement.service.impl.BookServiceImpl;
import com.jdbcconnectivity.LibraryManagement.service.impl.MemberServiceImpl;
import com.jdbcconnectivity.LibraryManagement.service.impl.IssueServiceImpl;

import java.sql.Date;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    static BookService bookService = new BookServiceImpl();
    static MemberService memberService = new MemberServiceImpl();
    static IssueService issueService = new IssueServiceImpl();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Issued Books");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    addMember();
                    break;

                case 4:
                    viewMembers();
                    break;

                case 5:
                    issueBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    viewIssuedBooks();
                    break;

                case 8:
                    System.out.println("Thank you! Application exited.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- BOOK OPERATIONS ----------------

    private static void addBook() {
        sc.nextLine();
        Book book = new Book();

        System.out.print("Book Title: ");
        book.setTitle(sc.nextLine());

        System.out.print("Author: ");
        book.setAuthor(sc.nextLine());

        System.out.print("Quantity: ");
        book.setQuantity(sc.nextInt());

        bookService.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void viewBooks() {
        bookService.getAllBooks().forEach(b ->
                System.out.println(
                        b.getBookId() + " | " +
                        b.getTitle() + " | " +
                        b.getAuthor() + " | Qty: " +
                        b.getQuantity()
                )
        );
    }

    // ---------------- MEMBER OPERATIONS ----------------

    private static void addMember() {
        sc.nextLine();
        Member member = new Member();

        System.out.print("Member Name: ");
        member.setName(sc.nextLine());

        System.out.print("Phone: ");
        member.setPhone(sc.nextLine());

        System.out.print("Email: ");
        member.setEmail(sc.nextLine());

        memberService.addMember(member);
        System.out.println("Member added successfully!");
    }

    private static void viewMembers() {
        memberService.getAllMembers().forEach(m ->
                System.out.println(
                        m.getMemberId() + " | " +
                        m.getName() + " | " +
                        m.getPhone() + " | " +
                        m.getEmail()
                )
        );
    }

    // ---------------- ISSUE / RETURN ----------------

    private static void issueBook() {
        Issue issue = new Issue();

        System.out.print("Book ID: ");
        issue.setBookId(sc.nextInt());

        System.out.print("Member ID: ");
        issue.setMemberId(sc.nextInt());

        issue.setIssueDate(new Date(System.currentTimeMillis()));

        issueService.issueBook(issue);
        bookService.updateBookQuantity(issue.getBookId(), -1);

        System.out.println("Book issued successfully!");
    }

    private static void returnBook() {
        System.out.print("Issue ID: ");
        int issueId = sc.nextInt();

        issueService.returnBook(issueId);
        System.out.println("Book returned successfully!");
    }

    private static void viewIssuedBooks() {
        issueService.getAllIssuedBooks().forEach(i ->
                System.out.println(
                        i.getIssueId() +
                        " | Book ID: " + i.getBookId() +
                        " | Member ID: " + i.getMemberId() +
                        " | Issue Date: " + i.getIssueDate() +
                        " | Return Date: " + i.getReturnDate()
                )
        );
    }
}
