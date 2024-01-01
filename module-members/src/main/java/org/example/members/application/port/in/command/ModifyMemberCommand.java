package org.example.members.application.port.in.command;

import java.time.LocalDate;

import org.example.common.annotation.validator.SelfValidator;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMemberCommand extends SelfValidator<ModifyMemberCommand> {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String zipcode;

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

	public ModifyMemberCommand(
		String name,
		String zipcode,
		String address1,
		String address2,
		String cellPhone,
		LocalDate birth
	) {
		this.name = name;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.cellPhone = cellPhone;
		this.birth = birth;

		this.validateSelf();
	}
}
