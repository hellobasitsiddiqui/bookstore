package com.basitsiddiqui.bookstore.web;

import com.basitsiddiqui.bookstore.data.BookEntity;

import java.util.List;

public class BookResult {
    private List<BookEntity> books;

    public BookResult(List<BookEntity> books) {
        this.books = books;
    }

    public List<BookEntity> getBooks() {
        return books;
    }
}
