package org.example.books.domain.book.vo;

import lombok.Value;

@Value
public class BookId {
	Long id;

	public BookId(Long id) {
		this.id = id;
	}
}
