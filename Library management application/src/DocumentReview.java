public class DocumentReview {
    private String reviewText ="";
    private double reviewScore;
    private User user;
    public DocumentReview(String reviewText, double reviewScore, User user) {
        this.reviewText = reviewText;
        this.reviewScore = reviewScore;
        this.user = user;
    }

    public boolean isReviewAgain(DocumentReview otherReview) {
        return otherReview.getUser().getUserId().equals(user.getUserId());
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(double reviewScore) {
        this.reviewScore = reviewScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
