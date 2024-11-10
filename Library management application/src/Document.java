import java.util.ArrayList;
import java.util.List;

public abstract class Document {
    protected String title;
    protected String author;
    protected String ISBN;
    protected int quantity;
    protected List<DocumentReview> reviewsList = new ArrayList<DocumentReview>();

    public Document(String title, String author, String ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public void addReview(DocumentReview newReview) {
        DocumentReview r = null;
        for (DocumentReview review : reviewsList) {
            if (review.isReviewAgain(newReview)) {
                r = review;
                break;
            }
        }
        if (r != null) reviewsList.remove(r);
        reviewsList.add(newReview);
    }

    public String printReviews() {
        String reviews = "";
        double avgScore= 0;
        for (DocumentReview r : reviewsList) {
            avgScore += r.getReviewScore();
            reviews += String.format("UserID: %s\n\tScore: %.1f\n",r.getUser().getUserId(), r.getReviewScore());
            if (!r.getReviewText().equals("")) {
                reviews += String.format("\tReview: %s\n",r.getReviewText());
            }
        }

        return avgScore == 0 ? "This document hasn't had any reviews!" : String.format("Average Score: %.1f\n%s",(avgScore/reviewsList.size()), reviews);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public abstract String printInfo();

}
