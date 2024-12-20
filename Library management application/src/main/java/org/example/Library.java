package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private static Library instance;
    private List<Document> documents;
    private List<User> users;

    private Library() {
        documents = new ArrayList<Document>();
        users = new ArrayList<User>();
        addUser(new Librarian("Hoang",2003,"0","0948","0"));
        addUser(new Member("tien",2003,"1","0933","1"));
        addUser(new Member("tam",2004,"2","03233","2"));
        addDocument(new Book("math","Nguyen Van Hoang","978-3-16-148410-0",3,"study"));
        addDocument(new Book("physics","Tran Thi Mai","978-1-4028-9462-6",2,"reference"));
        addDocument(new Book("chemistry","Le Quang Hieu","978-0-545-01022-1",5,"study"));
        addDocument(new Book("biology","Pham Minh Tuan","978-0-06-112241-5",4,"research"));
        addDocument(new Book("history","Dang Thi Lan","978-0-141-03435-8",6,"textbook"));
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean addUser(User newUser) {
        Optional<User> userOpt = findUserByUserId(newUser.getUserId());
        if (userOpt.isPresent()) {
            return false;
        }
        users.add(newUser);
        return true;
    }

    public Optional<User> findUserByUserId(String userId) {
        for (User user : users) {
            if(user.getUserId().equals(userId)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean userBorrow(String ISBN, String userId) throws UserNotFoundException, ISBNNotFoundException, NoDocumentAvailableException {
        Optional<User> userOpt = findUserByUserId(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user instanceof Member) {
                Optional<Document> docOpt = findDocumentByIBSN(ISBN);
                if (docOpt.isPresent()) {
                    Document doc = docOpt.get();
                    if (doc.getQuantity() > 0) {
                        if(((Member) user).borrowDocument(doc)) {
                            doc.setQuantity(doc.getQuantity() - 1);
                            return true;
                        }
                    } else {throw new NoDocumentAvailableException();}
                } else { throw new ISBNNotFoundException();}
            }
        } else { throw new UserNotFoundException();}

            return false;
    }

    public boolean userReturn(String ISBN, String userId) throws UserNotFoundException, ISBNNotFoundException {
        Optional<User> userOpt = findUserByUserId(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user instanceof Member) {
                Optional<Document> docOpt = findDocumentByIBSN(ISBN);
                if (docOpt.isPresent()) {
                    Document document = docOpt.get();
                    document.setQuantity(document.getQuantity() + 1);
                    if(((Member) user).returnBorrowedDocument(document)){
                        return true;
                    }
                    return false;
                } else { throw new ISBNNotFoundException();}
            }
        } else { throw new UserNotFoundException();}
        return false;
    }

    public boolean isISBNExist(String ISBN) {
        for (Document doc : documents) {
            if(doc.getISBN().equals(ISBN)) {
                return true;
            }
        }
        return false;
    }

    public boolean addDocument(Document document) {
        if (isISBNExist(document.getISBN())) {
            return false;
        }
        documents.add(document);
        return true;
    }

    public boolean removeDocument(Document document) {
        if (documents.contains(document)) {
            documents.remove(document);
            return true;
        }
        return false;
    }

    public boolean removeDocumentByISBN(String ISBN) {
        Optional<Document> docOpt = findDocumentByIBSN(ISBN);
        if (docOpt.isPresent()) {
            documents.remove(docOpt.get());
            return true;
        }
        return false;
    }

    public Optional<Document> findDocumentByIBSN(String IBSN) {
        for (Document document : documents) {
            if(document.getISBN().equals(IBSN)) {
                return Optional.of(document);
            }
        }
        return Optional.empty();
    }

    public List <Document> findDocumentsByAuthor(String author) {
        List<Document> list = new ArrayList<>();
        for (Document document : documents) {
            if(document.getAuthor().equals(author)) {
                list.add(document);
            }
        }
        return list;
    }

    public List <Document> findDocumentsByTitle(String title) {
        List<Document> list = new ArrayList<>();
        for (Document document : documents) {
            if(document.getTitle().equals(title)) {
                list.add(document);
            }
        }
        return list;
    }

    public List<Document> findBooksByGenre(String genre) {
        List<Document> list = new ArrayList<>();
        for (Document document : documents) {
            if (document instanceof Book && ((Book) document).getGenre().equals(genre)) {
                list.add(document);
            }
        }
        return list;
    }

    public List<Document> findThesesByTopic(String topic) {
        List<Document> list = new ArrayList<>();
        for (Document document : documents) {
            if (document instanceof Thesis && ((Thesis) document).getTopic().equals(topic)) {
                list.add(document);
            }
        }
        return list;
    }

    public String printDocumentsInfo() {
        String info = "";
        for (Document document : documents) {
            info += document.printInfo();
        }
            return info;
    }
}
