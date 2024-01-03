package org.example.books.adapter.in.web.v1.category;

import org.example.books.adapter.in.web.v1.category.dto.request.RegisterBookCategoryRequest;
import org.example.books.application.port.in.category.IRegisterBookCategoryUsecase;
import org.example.books.application.port.in.category.command.RegisterBookCategoryCommand;
import org.example.books.domain.category.vo.BookCategoryId;
import org.example.common.annotation.controller.AdminController;
import org.example.common.annotation.service.WebAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "admin", description = "api for admin")
@AdminController("v1/books-categories")
@RequiredArgsConstructor
@WebAdapter
public class AdminBookCategoryController {

	private final IRegisterBookCategoryUsecase registerBookCategoryUsecase;

	@Operation(summary = "register", description = "register book category")
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "201",
			description = "created",
			content = {
				@Content(
					mediaType = "application/json",
					schema = @Schema(implementation = BookCategoryId.class))
			})
	})
	@PostMapping()
	public ResponseEntity<BookCategoryId> registerMember(
		@RequestBody RegisterBookCategoryRequest request
	) {
		RegisterBookCategoryCommand command = RegisterBookCategoryCommand.builder()
			.name(request.getName())
			.build();

		BookCategoryId bookCategoryId = this.registerBookCategoryUsecase.register(command);

		return ResponseEntity.status(HttpStatus.CREATED).body(bookCategoryId);
	}

	// find all

	// modify

	// delete
}
