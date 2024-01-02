package org.example.books.domain.category.vo;

import lombok.Value;

@Value
public class BookCategoryName {
	String name;

	public BookCategoryName(String name) {
		this.name = name;
	}
}
