package org.example.books.domain.book;

import java.time.LocalDateTime;
import java.util.List;

import org.example.books.domain.book.vo.BookId;
import org.example.books.domain.book.vo.BookMaker;
import org.example.books.domain.book.vo.BookStatus;
import org.example.books.domain.book.vo.BookTitle;
import org.example.books.domain.category.BookCategory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Book {
	private BookId id;

	private BookTitle title;

	private BookMaker maker;

	private List<BookCategory> categories;

	private BookStatus status;

	private LocalDateTime createdAt;

	public static Book create(
		String title,
		String author,
		String publisher,
		List<BookCategory> categories
	) {
		return new Book(
			new BookId(0L),
			new BookTitle(title),
			new BookMaker(author, publisher),
			categories,
			BookStatus.borrowable,
			LocalDateTime.now()
		);
	}

	public static Book from(
		Long id,
		String title,
		String author,
		String publisher,
		BookStatus status,
		List<BookCategory> categories
	) {
		return new Book(
			new BookId(id),
			new BookTitle(title),
			new BookMaker(author, publisher),
			categories,
			status,
			LocalDateTime.now()
		);
	}
}
