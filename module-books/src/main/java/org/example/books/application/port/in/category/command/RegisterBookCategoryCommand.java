package org.example.books.application.port.in.category.command;

import org.example.common.annotation.validator.SelfValidator;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterBookCategoryCommand extends SelfValidator<RegisterBookCategoryCommand> {

	@NotNull
	@NotEmpty
	private final String name;

	public RegisterBookCategoryCommand(String name) {
		this.name = name;

		this.validateSelf();
	}
}
