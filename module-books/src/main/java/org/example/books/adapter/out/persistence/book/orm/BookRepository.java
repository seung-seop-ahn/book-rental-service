package org.example.books.adapter.out.persistence.book.orm;

import org.example.books.adapter.out.persistence.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
