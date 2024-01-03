package org.example.books.adapter.in.web.v1.category.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBookCategoryRequest {

	@Schema(
		name = "name",
		description = "name",
		maxLength = 50,
		nullable = false,
		defaultValue = "",
		type = "string",
		example = "name"
	)
	private String name;
}
