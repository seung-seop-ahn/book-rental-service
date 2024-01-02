package org.example.books.adapter.out.persistence.category.mapper;

import java.util.List;

import org.example.books.adapter.out.persistence.category.entity.BookCategoryEntity;
import org.example.books.domain.category.BookCategory;

public class BookCategoryMapper {

	public static List<BookCategoryEntity> toEntity(List<BookCategory> categories) {
		return categories.stream().map(BookCategoryMapper::toEntityItem).toList();
	}

	public static BookCategoryEntity toEntityItem(BookCategory bookCategory) {
		return new BookCategoryEntity(
			bookCategory.getId().getId(),
			bookCategory.getName().getName()
		);
	}

	public static BookCategory toDomain(BookCategoryEntity entity) {
		return BookCategory.from(
			entity.getId(),
			entity.getName()
		);
	}
}
