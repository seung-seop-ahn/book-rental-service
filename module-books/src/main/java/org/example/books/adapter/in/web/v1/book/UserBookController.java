package org.example.books.adapter.in.web.v1.book;

import org.example.common.annotation.controller.UserController;
import org.example.common.annotation.service.WebAdapter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "user", description = "api for user")
@UserController("v1/books")
@RequiredArgsConstructor
@WebAdapter
public class UserBookController {
	// search by title, author, publisher, category
}
