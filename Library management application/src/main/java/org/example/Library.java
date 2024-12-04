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
        addUser(new Librarian("Hoang",2003,"2102","0948","123456"));
        addUser(new Member("tien",2003,"2111","0933","123456"));
        addUser(new Member("tam",2004,"111","03233","123456"));
        addDocument(new Book("oop","nvh","123",1,"st"));
        addDocument(new Book("lol","riot","000",2,"game"));
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

    public boolean removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            return true;
        }
        return false;

    }

    public boolean removeUserByUserId(String userId) {
        Optional<User> userOpt = findUserByUserId(userId);
        if (userOpt.isPresent()) {
            users.remove(userOpt.get());
            return true;
        }
        return false;
    }

    public boolean isUserBorrowed(String ISBN, String userId) throws UserNotFoundException, ISBNNotFoundException{
        Optional<User> userOpt = findUserByUserId(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user instanceof Member) {
                Optional<Document> docOpt = findDocumentByIBSN(ISBN);
                if (docOpt.isPresent()) {
                    Document doc = docOpt.get();
                    if (((Member) user).isBorrowedDocument(doc)) {
                        return true;
                    }
                } else {throw new ISBNNotFoundException();}
            }
        } else { throw new UserNotFoundException();}
        return false;
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
//            for (User user : users) {
//                if(user.getUserId().equals(userId) && user instanceof Member) {
//                    for (Document document : documents) {
//                        if(document.getISBN().equals(ISBN) && document.getQuantity() > 0) {
//                            document.setQuantity(document.getQuantity() - 1);
//                            ((Member) user).borrowDocument(document);
//                            return true;
//                        }
//                    }
//                }
//            }
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

//        for (User user : users) {
//            if(user.getUserId().equals(userId) && user instanceof Member) {
//                for (Document document : documents) {
//                    if(document.getISBN().equals(ISBN)) {
//                        document.setQuantity(document.getQuantity() + 1);
//                        if(((Member) user).returnBorrowedDocument(document)){
//                            return true;
//                        }
//                        return false;
//                    }
//                }
//            }
//        }
//        return false;
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
            info += document.printInfo() + "\n";
        }
            return info;
    }
}
