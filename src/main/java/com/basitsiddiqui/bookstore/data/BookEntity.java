package com.basitsiddiqui.bookstore.data;

import java.util.Objects;

public class BookEntity {

    private final long id;
    private final long price;
    private final String title;
    private final String author;
    private final String isbn;
    private final BookCategory category;

    public BookEntity(long id, long price, String title, String author, String isbn, BookCategory category) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookCategory getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
