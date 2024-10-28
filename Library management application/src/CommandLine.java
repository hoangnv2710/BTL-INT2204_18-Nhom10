import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandLine {

    public static void choice1 () throws InputMismatchException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter Document Information!");
        System.out.println("Enter Document Title:");
        String title = s.nextLine();
        System.out.println("Enter Document Author:");
        String author = s.nextLine();
        System.out.println("Enter Document ISBN:");
        String ISBN = s.nextLine();
        System.out.println("Enter Document Quantity:");
        int quantity = s.nextInt();

        int choice;
        do {
            System.out.println("Select Document Type:");
            System.out.println("[1] Book");
            System.out.println("[2] Thesis");
            choice = s.nextInt();
            s.nextLine();
        } while (choice != 1 && choice != 2);

        Document doc;
        if (choice == 1) {
            System.out.println("Enter Book Genre:");
            String genre = s.nextLine();
            doc = new Book(title,author,ISBN,quantity,genre);
        } else {
            System.out.println("Enter Thesis Topic:");
            String topic = s.nextLine();
            doc = new Thesis(title,author,ISBN,quantity,topic);
        }

        Library library = Library.getInstance();
        if(library.addDocument(doc)) {
            System.out.println("Document added successfully!");
        } else {
            System.out.println("Unable to add the document, the ISBN already exists!");
        }
    }

    public static void choice2() {
        System.out.println("Please Enter Document ISBN:");
        Scanner s = new Scanner(System.in);
        String ISBN = s.nextLine();
        Library library = Library.getInstance();
        if(library.removeDocumentByISBN(ISBN)) {
            System.out.println("Document removed successfully!");
        } else {
            System.out.println("Unable to remove the document, the ISBN does not exist!");
        }
    }

    public static void choice3() {
        System.out.println("Please Enter Document ISBN:");
        Scanner s = new Scanner(System.in);
        String ISBN = s.nextLine();
        Library library = Library.getInstance();
        if(library.removeDocumentByISBN(ISBN)) {
            System.out.println("Document removed successfully!");
        } else {
            System.out.println("Unable to remove the document, the ISBN does not exist!");
        }
    }

    public static void choice4() {

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
            System.out.println("Enter Document Title:");
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
            System.out.println("Enter Document Author:");
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
                System.out.println("Select Document Type:");
                System.out.println("[1] Book");
                System.out.println("[2] Thesis");
                choice1 = s.nextInt();
                s.nextLine();
            } while (choice1 != 1 && choice1 != 2);

            if (choice1 == 1) {
                System.out.println("Enter Book Genre:");
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
                System.out.println("Enter Thesis Topic:");
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
    }

    public static void choice5() {
        Library library = Library.getInstance();
//        System.out.println("Please Enter Document ISBN:");
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

    public static void choice6() {
        Login login = Login.getInstance();
        if (!login.isLoggedIn()) {
            System.out.println("You are not logged in!");
        } else if (login.isLoggedIn() && login.getUserLoggedIn() instanceof Member) {
            System.out.println("You do not have permission to access this feature!");
        } else {
            Library library = Library.getInstance();
            Scanner s = new Scanner(System.in);

            int choice;
            do {
                System.out.println("Select User Role");
                System.out.println("[1] Member");
                System.out.println("[2] Librarian");
                choice = s.nextInt();
                s.nextLine();
            } while (choice != 1 && choice != 2);

            boolean isMember = (choice == 1);

            System.out.println("Please Enter User Information!");
            System.out.println("Please Enter User Name:");
            String name = s.nextLine();
            System.out.println("Please Enter User Phone Number:");
            String phoneNumber = s.nextLine();
            System.out.println("Please Enter User Year Of Birth:");
            int yearOfBirth = s.nextInt();
            System.out.println("Please Enter User ID:");
            String userID = s.nextLine();
            System.out.println("Please Enter User Password:");
            String password = s.nextLine();

            if (login.register(name,yearOfBirth,userID,phoneNumber,password,isMember)) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("User registration failed!");
            }
        }
    }

    public static void choice7() {

    }

    public static void choice8() {

    }

    public static void choice9() {

    }

    public static void choice10() {

    }
}
