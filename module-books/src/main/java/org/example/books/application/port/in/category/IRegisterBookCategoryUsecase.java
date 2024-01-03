package org.example.books.application.port.in.category;

import org.example.books.application.port.in.category.command.RegisterBookCategoryCommand;
import org.example.books.domain.category.vo.BookCategoryId;

public interface IRegisterBookCategoryUsecase {

	BookCategoryId register(RegisterBookCategoryCommand command);
}
