package BookLibraryPackage;

import java.util.List;

public class BookLibraryModel {

    private String name;
    private List<Book> books;

    public BookLibraryModel() {

    }

    public BookLibraryModel(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
