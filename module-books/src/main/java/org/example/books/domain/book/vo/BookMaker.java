package org.example.books.domain.book.vo;

import lombok.Value;

@Value
public class BookMaker {

	String author;

	String publisher;

	public BookMaker(String author, String publisher) {
		this.author = author;
		this.publisher = publisher;
	}
}
