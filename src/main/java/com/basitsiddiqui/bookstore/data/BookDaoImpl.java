package com.basitsiddiqui.bookstore.data;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * in-memory implementation of the {@link BookDao}.
 */
@Component
public class BookDaoImpl implements BookDao {

    private static Map<Long, BookEntity> properties = new HashMap<>();

    @Override
    public Optional<BookEntity> getOne(long id) {
        return Optional.ofNullable(properties.get(id));
    }

    @Override
    public Set<BookEntity> getAll() {
        return new HashSet<>(properties.values());
    }

    @Override
    public void clear() {
        properties.clear();
    }

    @Override
    public void save(BookEntity BookEntity) {
        properties.put(BookEntity.getId(), BookEntity);
    }
}