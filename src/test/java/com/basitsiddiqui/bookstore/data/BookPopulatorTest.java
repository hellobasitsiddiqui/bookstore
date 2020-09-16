package com.basitsiddiqui.bookstore.data;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BookDaoImplTest {

    private BookDaoImpl underTest;

    @BeforeEach
    void setup() {
        underTest = new BookDaoImpl();
        underTest.clear();
    }

    @AfterEach
    void tearDown() {
        underTest.clear();
    }

    @Test
    void shouldSaveBook() {
        BookEntity Book = new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        underTest.save(Book);

        Optional<BookEntity> one = underTest.getOne(1L);

        assertThat(one).isPresent();
        assertThat(one.get().getId()).isEqualTo(1L);
    }

    @Test
    void shouldReturnOptionalEmptyWhenBookNotFound() {
        Optional<BookEntity> one = underTest.getOne(1L);

        assertThat(one).isNotPresent();
    }

    @Test
    void shouldReturnDifferentList() {
        BookEntity Book = new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        underTest.save(Book);

        Set<BookEntity> BookEntityList = underTest.getAll();

        BookEntityList.add(new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY));

        Set<BookEntity> result = underTest.getAll();

        assertThat(result).hasSize(1);
    }

    @Test
    void shouldUpdateBook() {
        BookEntity Book = new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        underTest.save(Book);

        BookEntity BookUpdate = new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        underTest.save(BookUpdate);

        Optional<BookEntity> result = underTest.getOne(1L);

        assertThat(underTest.getAll()).hasSize(1);
        assertThat(result.get().getPrice()).isEqualTo(100L);
        assertThat(result.get().getId()).isEqualTo(1L);
    }

    @Test
    void shouldDeleteAllBooks() {
        BookEntity Book = new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        underTest.save(Book);

        underTest.clear();

        Set<BookEntity> BookEntities = underTest.getAll();

        assertThat(BookEntities).isEmpty();
    }

    @Test
    void shouldGetAll() {
        BookEntity book = new BookEntity(1L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        BookEntity book2 = new BookEntity(2L, 100L, "Scient of Art", "Artist", "33", BookCategory.PRODUCTIVITY);
        underTest.save(book);
        underTest.save(book2);

        Set<BookEntity> BookEntities = underTest.getAll();

        assertThat(BookEntities).hasSize(2);
    }

    @Test
    void shouldReturnEmptyListWhenNoBooks() {
        assertThat(underTest.getAll()).isEmpty();
    }
}
