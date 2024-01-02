package org.example.books.domain.category.vo;

import lombok.Value;

@Value
public class BookCategoryId {
	Long id;

	public BookCategoryId(Long id) {
		this.id = id;
	}
}
