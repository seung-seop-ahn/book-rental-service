package org.example.books.adapter.in.web.v1.book;

import org.example.common.annotation.controller.AdminController;
import org.example.common.annotation.service.WebAdapter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "admin", description = "api for admin")
@AdminController("v1/books")
@RequiredArgsConstructor
@WebAdapter
public class AdminBookController {
	// register

	// find

	// search by title, author, publisher, category

	// modify
}
