package org.example.books.adapter.out.persistence.agg;

import java.util.List;

import org.example.books.adapter.out.persistence.book.entity.BookEntity;
import org.example.books.adapter.out.persistence.book.mapper.BookMapper;
import org.example.books.adapter.out.persistence.category.entity.BookCategoryEntity;
import org.example.books.adapter.out.persistence.category.mapper.BookCategoryMapper;
import org.example.books.domain.book.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookEntityAgg {

	BookEntity book;
	List<BookCategoryEntity> bookCategories;

	public static BookEntityAgg toEntity(Book book) {
		return new BookEntityAgg(
			BookMapper.toEntity(book),
			BookCategoryMapper.toEntity(book.getCategories())
		);
	}

	public static Book toDomain(BookEntityAgg entityAgg) {
		return BookMapper.toDomain(entityAgg);
	}
}
