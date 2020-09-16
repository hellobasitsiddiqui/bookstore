package com.basitsiddiqui.bookstore.web;

import com.basitsiddiqui.bookstore.data.BookCategory;
import com.basitsiddiqui.bookstore.data.BookEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookstoreController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public String welcome(){
        return "<H1>Welcome to our Bookstore!</H1>";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/books")
    public List<BookEntity> getBooks(){
        return Arrays.asList(
                new BookEntity(1, 10, "Spead Reading", "Tony Buzan", "978-1406644296", BookCategory.PRODUCTIVITY ),
                new BookEntity(2, 20, "Mind Mapping", "Tony Buzan", "978-1406644266", BookCategory.PRODUCTIVITY ),
                new BookEntity(3, 23, "Brief History of Time", "Stephen Hawkings", "978-0593060506", BookCategory.SCIENCE)
        );
    }
}
