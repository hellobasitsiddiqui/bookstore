package com.basitsiddiqui.bookstore.web;

import com.basitsiddiqui.bookstore.data.BookCategory;
import com.basitsiddiqui.bookstore.data.BookDao;
import com.basitsiddiqui.bookstore.data.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookstoreController {

    @Autowired
    BookDao bookDao;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public String welcome(){
        return "<H1>Welcome to our Bookstore!</H1>";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/books")
    public BookResult getBooks(){
        return new BookResult(new ArrayList<>(bookDao.getAll()));
    }

    @GetMapping("/books/{id}")
    public BookResult getBook(@PathVariable String id){
        return new BookResult(new ArrayList<>(bookDao.getAll().stream().
                filter(e -> e.getId() == Long.parseLong(id)).collect(Collectors.toList())));
    }
}
