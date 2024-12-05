package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandLine {
    public static void commandLineStart() {
        try {
            int choice;
            System.out.println("\nWelcome to My Application!");
            do {
                System.out.println("\nChoose an option:");
                System.out.println("[0] Exit");
                System.out.println("[1] Add Document");
                System.out.println("[2] Remove Document");
                System.out.println("[3] Update Document");
                System.out.println("[4] Find Document");
                System.out.println("[5] Display All Document");
                System.out.println("[6] Add User");
                System.out.println("[7] Borrow Document");
                System.out.println("[8] Return Document");
                System.out.println("[9] Display User Info");
                System.out.println("[10] Review Document");
                System.out.println("[11] Login & Logout");
                System.out.print("Your action: ");

                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                System.out.println();
                switch (choice) {
                    case 0:
                        System.out.println("Bye<3");
                        break;
                    case 1:
                        CommandLine.addDocumentCommand();
                        break;
                    case 2:
                        CommandLine.reomoveDocumentCommand();
                        break;
                    case 3:
                        CommandLine.updateDocumentCommand();
                        break;
                    case 4:
                        CommandLine.findDocumentCommand();
                        break;
                    case 5:
                        CommandLine.displayAllDocumentCommand();
                        break;
                    case 6:
                        CommandLine.addUserCommand();
                        break;
                    case 7:
                        CommandLine.borrowDocumentCommand();
                        break;
                    case 8:
                        CommandLine.returnDocumentCommand();
                        break;
                    case 9:
                        CommandLine.displayUserCommand();
                        break;
                    case 10:
                        CommandLine.reviewCommand();
                        break;
                    case 11:
                        CommandLine.loginCommand();
                        break;
                    default:
                        System.out.println("Action is not supported");
                }
            } while (choice != 0);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            commandLineStart();
        }

    }

    public static void addDocumentCommand() {
        try {
            Scanner s = new Scanner(System.in);
            Library library = Library.getInstance();
            System.out.println("Enter the information for the document you want to add.");
            String title = "";
            do {
                System.out.println("Enter the document title:");
                title = s.nextLine();
                if (title.equals("")) {
                    System.out.println("Title cannot be empty. Please try again!");
                }
            } while (title.equals(""));
            
            System.out.println("Enter the document author:");
            String author = s.nextLine();

            String ISBN = "";
            do {
                System.out.println("Enter the document ISBN:");
                ISBN = s.nextLine();
                if (ISBN.equals("")) {
                    System.out.println("The ISBN cannot be empty. Please try again!");
                } else if (library.isISBNExist(ISBN)) {
                    System.out.println("The ISBN already exists. Please try again!");
                    ISBN = "";
                }
            } while (ISBN.equals(""));

            int quantity = 0;
            do {
                System.out.println("Enter the document quantity:");
                quantity = s.nextInt();
                if ( quantity < 0) {
                    System.out.println("Quantity cannot be negative. Please try again!");
                }
            } while (quantity < 0);

            int choice;
            do {
                System.out.println("Select document type:");
                System.out.println("[1] Book");
                System.out.println("[2] Thesis");
                choice = s.nextInt();
                s.nextLine();
            } while (choice != 1 && choice != 2);

            Document doc;
            if (choice == 1) {
                System.out.println("Enter book genre:");
                String genre = s.nextLine();
                doc = new Book(title,author,ISBN,quantity,genre);
            } else {
                System.out.println("Enter thesis topic:");
                String topic = s.nextLine();
                doc = new Thesis(title,author,ISBN,quantity,topic);
            }

            choice = -1;

            do {
                System.out.println("Do you want to save?");
                System.out.println("[0] NO");
                System.out.println("[1] YES");
                choice = s.nextInt();
                if (choice < 0 || choice > 1) {
                    System.out.println("Please try again!");
                } else if (choice == 0) {
                    return;
                }
            } while (choice < 0 || choice > 1);

            if(library.addDocument(doc)) {
                System.out.println("Document added successfully!");
            } else {
                System.out.println("Unable to add the document!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            addDocumentCommand();
        }
    }

    public static void reomoveDocumentCommand() {
        Scanner s = new Scanner(System.in);
        Library library = Library.getInstance();

        String ISBN = "";
        do {
            System.out.println("Enter the ISBN of the document you want to remove:");
            ISBN = s.nextLine();
            if (ISBN.equals("")) {
                System.out.println("The ISBN cannot be empty. Please try again!");
            } else if (!library.isISBNExist(ISBN)) {
                System.out.println("The ISBN does not exists. Do you want to try again?");
                int choice;

                do {
                    System.out.println("Select your choice:");
                    System.out.println("[0] No, take me back to the main menu");
                    System.out.println("[1] Yes, I’d like to try again");
                    System.out.println("[2] I forgot the ISBN. I’ll find the document first");
                    choice = s.nextInt();
                    s.nextLine();
                    if (choice == 0) {
                        return;
                    } else if (choice == 2) {
                        findDocumentCommand();
                    }
                } while (choice < 0 || choice > 2);
                ISBN = "";
            }
        } while (ISBN.equals(""));

        if(library.removeDocumentByISBN(ISBN)) {
            System.out.println("Document removed successfully!");
        } else {
            System.out.println("Unable to remove the document. Something went wrong!");
        }
    }

    public static void updateDocumentCommand() {
        try {
            Login login = Login.getInstance();
            if (!login.isLoggedIn()) {
                System.out.println("You are not logged in!");
            } else if (login.isLoggedIn() && login.getUserLoggedIn() instanceof Member) {
                System.out.println("You do not have permission to access this feature!");
            } else {
                Library library = Library.getInstance();
                Scanner s = new Scanner(System.in);

                System.out.println("Enter the document ISBN:");
                String ISBN = s.nextLine();

                Optional<Document> docOpt = library.findDocumentByIBSN(ISBN);
                if (docOpt.isPresent()) {
                    System.out.println("Document Information");
                    Document doc = docOpt.get();
                    System.out.println(doc.printInfo());
                    int choice;
                    do {
                        System.out.println("Select the information you want to change on the document:");
                        System.out.println("[1] Title");
                        System.out.println("[2] Author");
                        System.out.println("[3] Quantity");
                        choice = s.nextInt();
                        s.nextLine();
                    } while (choice != 1 && choice != 2 && choice != 3);
                    if (choice == 1) {
                        System.out.println("Enter new document title:");
                        String newTitle = s.nextLine();
                        doc.setTitle(newTitle);
                    } else if (choice == 2) {
                        System.out.println("Enter new document author:");
                        String newAuthor = s.nextLine();
                        doc.setAuthor(newAuthor);
                    } else if (choice == 3) {
                        System.out.println("Enter new document quantity:");
                        int newQuantity = s.nextInt();
                        doc.setQuantity(newQuantity);
                    }
                    System.out.println("Updated successfully");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            updateDocumentCommand();
        }
    }

    public static void findDocumentCommand() {
        try {
            Scanner s = new Scanner(System.in);
            Library library = Library.getInstance();
            int choice;
            do {
                System.out.println("Search for documents by title, author, or document types.");
                System.out.println("[1] Title");
                System.out.println("[2] Author");
                System.out.println("[3] Document Type");
                choice = s.nextInt();
                s.nextLine();
            } while (choice != 1 && choice != 2 && choice != 3);

            if (choice == 1) {
                System.out.println("Enter the document title:");
                String title = s.nextLine();
                List<Document> list = library.findDocumentsByTitle(title);
                if (list.size() == 0) {
                    System.out.println("Title not found!");
                } else {
                    for (Document doc : list) {
                        System.out.println(doc.printInfo());
                    }
                }
            } else if (choice == 2) {
                System.out.println("Enter the document author:");
                String author = s.nextLine();
                List<Document> list = library.findDocumentsByAuthor(author);
                if (list.size() == 0) {
                    System.out.println("Author not found!");
                } else {
                    for (Document doc : list) {
                        System.out.println(doc.printInfo());
                    }
                }
            } else if (choice == 3) {
                int choice1;
                do {
                    System.out.println("Select document type:");
                    System.out.println("[1] Book");
                    System.out.println("[2] Thesis");
                    choice1 = s.nextInt();
                    s.nextLine();
                } while (choice1 != 1 && choice1 != 2);

                if (choice1 == 1) {
                    System.out.println("Enter book genre:");
                    String genre = s.nextLine();
                    List<Document> list = library.findBooksByGenre(genre);
                    if (list.size() == 0) {
                        System.out.println("Genre not found!");
                    } else {
                        for(Document doc : list) {
                            System.out.println(doc.printInfo());
                        }
                    }
                } else {
                    System.out.println("Enter thesis topic:");
                    String topic = s.nextLine();
                    List<Document> list = library.findBooksByGenre(topic);
                    if (list.size() == 0) {
                        System.out.println("Topic not found!");
                    } else {
                        for(Document doc : list) {
                            System.out.println(doc.printInfo());
                        }
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            findDocumentCommand();
        }

    }

    public static void displayAllDocumentCommand() {
        Library library = Library.getInstance();
//        System.out.println("Enter the document ISBN:");
//        Scanner s = new Scanner(System.in);
//        String ISBN = s.nextLine();
//        Optional<Document> docOpt = library.findDocumentByIBSN(ISBN);
//        if (docOpt.isPresent()) {
//            System.out.println(docOpt.get().printInfo());
//        } else {
//            System.out.println("Document not found!");
//        }

        System.out.println(library.printDocumentsInfo());
    }

    public static void addUserCommand() {
        try {
            Login login = Login.getInstance();
            if (!login.isLoggedIn()) {
                System.out.println("You need to log in to access this feature!");
            } else if (login.isLoggedIn() && login.getUserLoggedIn() instanceof Member) {
                System.out.println("You do not have permission to access this feature!");
            } else {
                Library library = Library.getInstance();
                Scanner s = new Scanner(System.in);

                int choice;
                do {
                    System.out.println("Select user role");
                    System.out.println("[1] Member");
                    System.out.println("[2] Librarian");
                    choice = s.nextInt();
                    s.nextLine();
                } while (choice != 1 && choice != 2);

                boolean isMember = (choice == 1);

                System.out.println("Enter user information!");
                System.out.println("Enter user name:");
                String name = s.nextLine();
                System.out.println("Enter user phone number:");
                String phoneNumber = s.nextLine();
                System.out.println("Enter user year of birth:");
                int yearOfBirth = s.nextInt();
                s.nextLine();
                String userID = "";
                do {
                    System.out.println("Enter user ID:");
                    userID = s.nextLine();
                    if (userID.equals("")) {
                        System.out.println("The UserID cannot be empty. Please try again!");
                    }
                } while (userID.equals(""));

                String password = "";
                do {
                    System.out.println("Enter user password:");
                    password = s.nextLine();
                    if (password.equals("")) {
                        System.out.println("The password cannot be empty. Please try again.!");
                    }
                } while (password.equals(""));

                if (login.register(name,yearOfBirth,userID,phoneNumber,password,isMember)) {
                    System.out.println("User registered successfully!");
                } else {
                    System.out.println("User registration failed!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            addUserCommand();
        }
    }

    public static void borrowDocumentCommand() {

        Login login = Login.getInstance();
        if (!login.isLoggedIn()) {
            System.out.println("You need to log in to access this feature!");
        } else if (login.isLoggedIn() && login.getUserLoggedIn() instanceof Member) {
            System.out.println("Please contact the librarian!");
        } else {
            Library library = Library.getInstance();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter member ID:");
            String memberID = s.nextLine();
            System.out.println("Enter the document ISBN:");
            String ISBN = s.nextLine();

            try {
                if (library.userBorrow(ISBN, memberID)) {
                    System.out.println("Borrow request successful!");
                } else {
                    System.out.println("Unable to complete borrow request!");
                }
            } catch (UserNotFoundException e) {
                System.out.println("User not found. Please try again!");
                borrowDocumentCommand();
            } catch (ISBNNotFoundException e) {
                System.out.println("ISBN not found. Please try again!");
                borrowDocumentCommand();
            } catch (NoDocumentAvailableException e) {
                System.out.println("All of this document has been borrowed!");
            }
        }
    }

    public static void returnDocumentCommand() {
        Login login = Login.getInstance();
        if (!login.isLoggedIn()) {
            System.out.println("You are not logged in!");
        } else if (login.isLoggedIn() && login.getUserLoggedIn() instanceof Member) {
            System.out.println("Please contact the librarian!");
        } else {
            Library library = Library.getInstance();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter member ID:");
            String memberID = s.nextLine();
            System.out.println("Enter the document ISBN:");
            String ISBN = s.nextLine();
            try {
                if (library.userReturn(ISBN, memberID)) {
                    System.out.println("Return has been completed!");
                } else {
                    System.out.println("Unable to complete return!");
                }
            } catch (UserNotFoundException e) {
                System.out.println("User not found. Please try again!");
                reomoveDocumentCommand();
            } catch (ISBNNotFoundException e) {
                System.out.println("ISBN not found. Please try again!");
                reomoveDocumentCommand();
            }

        }
    }

    public static void displayUserCommand() {
        Login login = Login.getInstance();
        if (!login.isLoggedIn()) {
            System.out.println("You need to log in to access this feature!");
        } else if (login.isLoggedIn() && login.getUserLoggedIn() instanceof Member) {
            System.out.println(login.getUserLoggedIn().printInfo());
        } else {
            Library library = Library.getInstance();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter member ID:");
            String memberID = s.nextLine();
            Optional<User> userOpt = library.findUserByUserId(memberID);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                System.out.println(user.printInfo());
            } else {
                System.out.println("User not found!");
            }
        }
    }

    public static void reviewCommand() {
        try {
            Login login = Login.getInstance();
            Scanner s = new Scanner(System.in);

            if (login.isLoggedIn()) {
                Library library = Library.getInstance();
                int choice;
                do {
                    System.out.println("Select your choice:");
                    System.out.println("[0] Return to main menu");
                    System.out.println("[1] Check reviews");
                    System.out.println("[2] Add Review");
                    choice = s.nextInt();
                    s.nextLine();

                    if (choice == 1 || choice ==2) {
                        System.out.println("Enter the document ISBN:");
                        String ISBN = s.nextLine();
                        Optional<Document> docOpt = library.findDocumentByIBSN(ISBN);
                        if (docOpt.isPresent()) {
                            if(choice == 1) {
                                System.out.println(docOpt.get().printReviews());
                            } else {
                                int score = 0;
                                do {
                                    System.out.println("Enter the document score [1-5]: ");
                                    score = s.nextInt();
                                } while (score < 1 || score > 5);
                                s.nextLine();
                                System.out.println("Enter a review for the document:");
                                String review = s.nextLine();
                                DocumentReview newReview = new DocumentReview(review,score,login.getUserLoggedIn());
                                docOpt.get().addReview(newReview);
                                System.out.println("Document review added successfully!");
                            }
                        } else {
                            System.out.println("ISBN not found!");
                        }
                    }

                } while (choice != 0 && choice != 1 && choice != 2);

            } else {
                System.out.println("You need to log in to access this feature!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            reviewCommand();
        }
    }

    public static void loginCommand() {
        try {
            Login login = Login.getInstance();
            Scanner s = new Scanner(System.in);
            if (login.isLoggedIn()) {
                System.out.println("You are logged in!");
                int choice;
                do {
                    System.out.println("Select your choice:");
                    System.out.println("[0] Return to main menu");
                    System.out.println("[1] Change password");
                    System.out.println("[2] Logout");
                    choice = s.nextInt();
                    s.nextLine();
                } while (choice != 0 && choice != 1 && choice != 2);
                if (choice == 2) {
                    login.logout();
                    System.out.println("Logged out successfully!");
                } else if (choice == 1) {
                    System.out.println("New password:");
                    String password = s.nextLine();
                    login.getUserLoggedIn().setPassword(password);
                    System.out.println("New password updated successfully!");
                } else {
                    return;
                }
            } else {
                System.out.println("You are not logged in!");
                System.out.println("If you don't have an account, please contact the librarian!");
                int choice;
                do {
                    System.out.println("Select your choice:");
                    System.out.println("[0] Return to main menu");
                    System.out.println("[1] Login");
                    choice = s.nextInt();
                    s.nextLine();
                    if (choice == 1) {
                        System.out.println("Your userID");
                        String userID = s.nextLine();
                        System.out.println("Your password");
                        String password = s.nextLine();
                        if(login.login(userID,password)) {
                            System.out.println("Logged in successfully!");
                        } else {
                            System.out.println("Login failed. Please try again!");
                            choice = -1;
                        }
                    }
                } while (choice != 0 && choice != 1 );

            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again!");
            loginCommand();
        }
    }
}
