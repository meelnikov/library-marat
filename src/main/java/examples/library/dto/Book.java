package examples.library.dto;

public class Book {

    private final long id;
    private final String author;
    private final String title;

    public Book(long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", author='").append(author).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}