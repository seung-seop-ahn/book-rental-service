package org.example.books.adapter.out.persistence.book.mapper;

import java.util.List;

import org.example.books.adapter.out.persistence.agg.BookEntityAgg;
import org.example.books.adapter.out.persistence.book.entity.BookEntity;
import org.example.books.adapter.out.persistence.category.entity.BookCategoryEntity;
import org.example.books.adapter.out.persistence.category.mapper.BookCategoryMapper;
import org.example.books.domain.book.Book;

public class BookMapper {

	public static BookEntity toEntity(Book book) {
		return new BookEntity(
			book.getId().getId(),
			book.getTitle().getTitle(),
			book.getMaker().getAuthor(),
			book.getMaker().getPublisher(),
			book.getStatus(),
			BookCategoryBitSumMapper.toBitSum(book)
		);
	}

	public static Book toDomain(BookEntityAgg entityAgg) {
		BookEntity book = entityAgg.getBook();
		List<BookCategoryEntity> categories = entityAgg.getBookCategories();

		return Book.from(
			book.getId(),
			book.getTitle(),
			book.getAuthor(),
			book.getPublisher(),
			book.getStatus(),
			categories.stream().map(BookCategoryMapper::toDomain).toList()
		);
	}
}
