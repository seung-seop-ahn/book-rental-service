package org.example.books.application.port.out.category;

import org.example.books.domain.category.BookCategory;

public interface IRegisterBookCategory {
	BookCategory create(BookCategory bookCategory);
}
