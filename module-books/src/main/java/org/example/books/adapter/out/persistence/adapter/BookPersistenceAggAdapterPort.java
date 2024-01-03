package org.example.books.adapter.out.persistence.adapter;

import org.example.books.adapter.out.persistence.book.orm.BookRepository;
import org.example.books.adapter.out.persistence.category.entity.BookCategoryEntity;
import org.example.books.adapter.out.persistence.category.mapper.BookCategoryMapper;
import org.example.books.adapter.out.persistence.category.orm.BookCategoryRepository;
import org.example.books.application.port.out.IBookCategoryPort;
import org.example.books.domain.category.BookCategory;
import org.example.common.annotation.service.PersistenceAdapter;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class BookPersistenceAggAdapterPort implements IBookCategoryPort {

	private final BookRepository bookRepository;
	private final BookCategoryRepository bookCategoryRepository;

	@Override
	public BookCategory create(BookCategory bookCategory) {
		BookCategoryEntity entity = BookCategoryMapper.toEntityItem(bookCategory);
		BookCategoryEntity saved = this.bookCategoryRepository.save(entity);
		return BookCategoryMapper.toDomain(saved);
	}
}
