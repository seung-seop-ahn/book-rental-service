package org.example.books.domain.category;

import org.example.books.domain.category.vo.BookCategoryId;
import org.example.books.domain.category.vo.BookCategoryName;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookCategory {

	private BookCategoryId id;

	private BookCategoryName name;

	public static BookCategory create(String name) {
		return new BookCategory(
			new BookCategoryId(0L),
			new BookCategoryName(name)
		);
	}

	public static BookCategory from(Long id, String name) {
		return new BookCategory(
			new BookCategoryId(id),
			new BookCategoryName(name)
		);
	}
}
