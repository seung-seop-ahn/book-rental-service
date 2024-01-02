package org.example.books.domain.book.vo;

import lombok.Value;

@Value
public class BookTitle {

	String title;

	public BookTitle(String title) {
		this.title = title;
	}
}
