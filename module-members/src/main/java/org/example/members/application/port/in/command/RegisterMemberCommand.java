package org.example.members.application.port.in.command;

import java.time.LocalDate;

import org.example.common.annotation.validator.SelfValidator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMemberCommand extends SelfValidator<RegisterMemberCommand> {

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Pattern(
		regexp = "^[a-zA-Z0-9!@#$%^&*]{8,16}$",
		message = "Needs 8~16 with uppercase, lowercase, number, special characters")
	private String password;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String zipCode;

	@NotNull
	@NotEmpty
	private String address1;

	@NotNull
	@NotEmpty
	private String address2;

	@NotNull
	@NotEmpty
	private String cellPhone;

	@NotNull
	private LocalDate birth;

	public RegisterMemberCommand(
		String email,
		String password,
		String name,
		String zipCode,
		String address1,
		String address2,
		String cellPhone,
		LocalDate birth
	) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.zipCode = zipCode;
		this.address1 = address1;
		this.address2 = address2;
		this.cellPhone = cellPhone;
		this.birth = birth;

		this.validateSelf();
	}
}
