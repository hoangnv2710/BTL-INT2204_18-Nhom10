public abstract class Document {
    private String title;
    private String author;
    private String ISBN;
    private int quantity;

    public Document(String title, String author, String ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
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
