import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;

    private List<Document> documents;
    private List<User> users;

    private Library() {
        documents = new ArrayList<Document>();
        users = new ArrayList<User>();
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

    public boolean addDocument(Document document) {
        for (Document doc : documents) {
            if(doc.getISBN().equals(document.getISBN())) {
                return false;
            }
        }
        documents.add(document);
        return true;
    }

    public boolean addUser(User newUser) {
        for (User user : users) {
            if(user.getUserId().equals(newUser.getUserId()) || user.getPhoneNumber().equals(newUser.getPhoneNumber())) {
                return false;
            }
        }
        users.add(newUser);
        return true;
    }

    public boolean removeDocument(Document document) {
        if (documents.contains(document)) {
            documents.remove(document);
            return true;
        }
        return false;
    }

    public boolean removeDocument(String ISBN) {
        for (Document document : documents) {
            if (document.getISBN().equals(ISBN)) {
                documents.remove(document);
                return true;
            }
        }
        return false;
    }

    public boolean removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            return true;
        }
        return false;

    }

    public boolean removeUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean userBorrow(String ISBN, String userId) {
            for (User user : users) {
                if(user.getUserId().equals(userId) && user instanceof Member) {
                    for (Document document : documents) {
                        if(document.getISBN().equals(ISBN) && document.getQuantity() > 0) {
                            document.setQuantity(document.getQuantity() - 1);
                            ((Member) user).borrowDocument(document);
                            return true;
                        }
                    }
                }
            }
            return false;
    }

    public boolean userReturn(String ISBN, String userId) {
        for (User user : users) {
            if(user.getUserId().equals(userId) && user instanceof Member) {
                for (Document document : documents) {
                    if(document.getISBN().equals(ISBN)) {
                        document.setQuantity(document.getQuantity() + 1);
                        ((Member) user).returnBorrowedDocument(document);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String printDocumentsInfo() {

        return "";
    }
}
