public class Book extends Document {
    private String genre;
    public Book(String title, String author, String ISBN, int quantity, String genre) {
        super(title, author, ISBN, quantity);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String printInfo() {
        return String.format("%s\n%s\n%s\n",getTitle(),getAuthor(),getISBN());
    }
}
