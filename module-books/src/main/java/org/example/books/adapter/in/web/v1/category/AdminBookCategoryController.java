package org.example.books.adapter.in.web.v1.category;

import org.example.common.annotation.controller.AdminController;
import org.example.common.annotation.service.WebAdapter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "admin", description = "api for admin")
@AdminController("v1/books-categories")
@RequiredArgsConstructor
@WebAdapter
public class AdminBookCategoryController {
	// register

	// find

	// modify

	// delete
}
