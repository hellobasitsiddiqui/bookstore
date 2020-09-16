package com.basitsiddiqui.bookstore.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Profile("!test") TODO use test profile and uncomment this line
@Component
public class DataPopulator {

    private final BookDao bookDao;

    @Autowired
    public DataPopulator(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostConstruct
    public void insertBookData() {
        bookDao.save(new BookEntity(1, 10, "Spead Reading", "Tony Buzan", "978-1406644296", BookCategory.PRODUCTIVITY ));
        bookDao.save(new BookEntity(2, 20, "Mind Mapping", "Tony Buzan", "978-1406644266", BookCategory.PRODUCTIVITY ));
        bookDao.save(new BookEntity(3, 23, "Brief History of Time", "Stephen Hawkings", "978-0593060506", BookCategory.SCIENCE));
        bookDao.save(new BookEntity(4, 4, "Harry Potter", "J. K. Rowling", "978-152662658", BookCategory.FICTION));
    }
}
