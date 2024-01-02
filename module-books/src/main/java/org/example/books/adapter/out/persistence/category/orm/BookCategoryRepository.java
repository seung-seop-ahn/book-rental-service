package org.example.books.adapter.out.persistence.category.orm;

import org.example.books.adapter.out.persistence.category.entity.BookCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategoryEntity, Long> {
}
