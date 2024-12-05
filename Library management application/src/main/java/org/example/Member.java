package org.example;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    private List<Document> borrowList = new ArrayList<Document>();

    public Member(String name, int yearOfBirth, String userId, String phoneNumber, String password) {
        super(name, yearOfBirth, userId, phoneNumber, password);
        this.borrowList = new ArrayList<Document>();
    }

    public List<Document> getborrowList() {
        return borrowList;
    }

    public void setborrowList(List<Document> borrowList) {
        this.borrowList = borrowList;
    }

    public boolean borrowDocument(Document document) {
        if (!this.borrowList.contains(document)) {
            borrowList.add(document);
            return true;
        }
        return false;
    }


    public boolean isBorrowedDocument(Document document) {
        return borrowList.contains(document);
    }

    public boolean returnBorrowedDocument(Document document) {
        if(borrowList.contains(document)) {
            this.borrowList.remove(document);
            return true;
        }
        return false;
    }

    public void returnborrowList(List<Document> documents) {
        for (Document document : documents) {
            returnBorrowedDocument(document);
        }
    }

    public String borrowedInfo() {
        if (borrowList.isEmpty()) {
            return name + " hasn't borrowed any documents.";
        } else {
            String info = name + " has borrowed the following documents\n";
            for (Document document : borrowList) {
                info += String.format("\t %-20s: %s - %s\n", document.getISBN(), document.getTitle(), document.getAuthor());
                //info += "\t" + document.getISBN() + " \t\t: " + document.getTitle() + " - " + document.getAuthor()   + "\n";
            }
            return info;
        }
    }

    @Override
    public String printInfo() {
        return String.format("Member ID: %s\n\tPassword: %s\n\tName: %s\n\tYear of Birth: %d\n\tPhone number: %s\n",
                userId, password, name, yearOfBirth, phoneNumber) + borrowedInfo();
    }

}
