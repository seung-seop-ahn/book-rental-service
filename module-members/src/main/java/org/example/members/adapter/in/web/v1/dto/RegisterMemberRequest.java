package org.example.members.adapter.in.web.v1.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberRequest {
	@Pattern(
		regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
		message = "email format"
	)
	@Schema(
		name = "email",
		description = "email",
		maxLength = 255,
		nullable = false,
		defaultValue = "",
		type = "string",
		format = "email",
		example = "user@example.com"
	)
	private String email;

	@Pattern(
		regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$",
		message = "8~16, uppercase, lowercase, number, special case"
	)
	@Schema(
		name = "password",
		description = "password",
		maxLength = 100,
		nullable = false,
		defaultValue = "",
		type = "string",
		example = "q1w2e3r4!"
	)
	private String password;

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

	@Pattern(
		regexp = "[0-9]{5,8}",
		message = "zipcode format"
	)
	@Schema(
		name = "zipcode",
		description = "zipcode",
		maxLength = 5,
		nullable = false,
		defaultValue = "",
		type = "string",
		example = "12345"
	)
	private String zipcode;

	@Schema(
		name = "address1",
		description = "address1",
		maxLength = 255,
		nullable = false,
		defaultValue = "",
		type = "string",
		example = "address1"
	)
	private String address1;

	@Schema(
		name = "address2",
		description = "address2",
		maxLength = 255,
		nullable = false,
		defaultValue = "",
		type = "string",
		example = "address2"
	)
	private String address2;

	@Pattern(
		regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",
		message = "cell phone format"
	)
	@Schema(
		name = "cellPhone",
		description = "cellPhone",
		maxLength = 20,
		nullable = false,
		defaultValue = "",
		type = "string",
		example = "010-1234-1234"
	)
	private String cellPhone;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Schema(
		name = "birth",
		description = "birth",
		nullable = false,
		defaultValue = "current_date",
		type = "string",
		format = "date",
		example = "1990-01-01"
	)
	private LocalDate birth;
}
