package com.basitsiddiqui.bookstore.data;

import java.util.Optional;
import java.util.Set;


/**
 * A repository for in Memory Books Collection
 */
public interface BookDao {

        Optional<BookEntity> getOne(long id);

        Set<BookEntity> getAll();

        void clear();

        void save(BookEntity bookEntity);
}
