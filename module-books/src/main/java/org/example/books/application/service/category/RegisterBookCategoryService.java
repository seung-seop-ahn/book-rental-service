package org.example.books.application.service.category;

import org.example.books.application.port.in.category.IRegisterBookCategoryUsecase;
import org.example.books.application.port.in.category.command.RegisterBookCategoryCommand;
import org.example.books.application.port.out.IBookCategoryPort;
import org.example.books.domain.category.BookCategory;
import org.example.books.domain.category.vo.BookCategoryId;
import org.example.common.annotation.service.Usecase;

import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class RegisterBookCategoryService implements IRegisterBookCategoryUsecase {

	private final IBookCategoryPort bookCategoryPort;

	@Override
	public BookCategoryId register(RegisterBookCategoryCommand command) {
		BookCategory bookCategory = BookCategory.create(command.getName());
		BookCategory saved = this.bookCategoryPort.create(bookCategory);
		return saved.getId();
	}
}
