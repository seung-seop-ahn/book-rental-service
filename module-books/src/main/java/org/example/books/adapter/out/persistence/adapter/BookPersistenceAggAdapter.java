package org.example.books.adapter.out.persistence.adapter;

import org.example.books.adapter.out.persistence.book.orm.BookRepository;
import org.example.books.adapter.out.persistence.category.orm.BookCategoryRepository;
import org.example.common.annotation.service.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class BookPersistenceAggAdapter {

	private final BookRepository bookRepository;
	private final BookCategoryRepository bookCategoryRepository;
}
