public class Thesis extends Document {
    private String topic;
    public Thesis(String title, String author, String ISBN, int quantity, String topic) {
        super(title, author, ISBN, quantity);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String printInfo() {
        return String.format("ISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\tDocument type: Thesis\n\tTopic: %s\n\tQuantity: %d\n",
                ISBN, title, author, topic, quantity);
    }
}
