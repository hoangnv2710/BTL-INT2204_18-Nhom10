import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private List<Document> borrowedDocuments = new ArrayList<Document>();

    public Member(String name, int yearOfBirth, String userId, String phoneNumber, String password) {
        super(name, yearOfBirth, userId, phoneNumber, password);
        this.borrowedDocuments = new ArrayList<Document>();
    }

    public List<Document> getBorrowedDocuments() {
        return borrowedDocuments;
    }

    public void setBorrowedDocuments(List<Document> borrowedDocuments) {
        this.borrowedDocuments = borrowedDocuments;
    }

    public boolean borrowDocument(Document document) {
        if (this.borrowedDocuments.contains(document)) {
            borrowedDocuments.add(document);
            return true;
        }
        return false;
    }

    public void borrowDocuments(List<Document> documents) {
        for (Document document : documents) {
            borrowedDocuments.add(document);
        }
    }

    public boolean returnBorrowedDocument(Document document) {
        if(borrowedDocuments.contains(document)) {
            this.borrowedDocuments.remove(document);
            return true;
        }
        return false;
    }

    public void returnBorrowedDocuments(List<Document> documents) {
        for (Document document : documents) {
            returnBorrowedDocument(document);
        }
    }


    @Override
    public String printInfo() {
        return "";
    }

}
