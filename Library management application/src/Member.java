import java.util.List;

public class Member extends User {
    private List<Document> borrowedDocuments;

    public Member(String name, int age, String userId, String phoneNumber, List<Document> borrowedDocuments) {
        super(name, age, userId, phoneNumber);
        this.borrowedDocuments = borrowedDocuments;
    }

    public List<Document> getBorrowedDocuments() {
        return borrowedDocuments;
    }

    public void setBorrowedDocuments(List<Document> borrowedDocuments) {
        this.borrowedDocuments = borrowedDocuments;
    }

    public void borrowDocuments(List<Document> documents) {
        this.borrowedDocuments.addAll(documents);
    }

    public boolean borrowDocument(Document document) {
        if (this.borrowedDocuments.contains(document)) {
            borrowedDocuments.add(document);
            return true;
        }
        return false;
    }


    public void returnBorrowedDocuments(List<Document> documents) {
        this.borrowedDocuments.removeAll(documents);
    }

    public boolean returnBorrowedDocument(Document document) {
        if(borrowedDocuments.contains(document)) {
            this.borrowedDocuments.remove(document);
            return true;
        }
        return false;
    }

    @Override
    public String printInfo() {
        return "";
    }

}
