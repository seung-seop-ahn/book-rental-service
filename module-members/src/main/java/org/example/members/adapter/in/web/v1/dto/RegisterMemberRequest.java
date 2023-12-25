package org.example.members.adapter.in.web.v1.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberRequest {
	private String email;

	private String password;

	private String name;

	private String zipCode;

	private String address1;

	private String address2;

	private String cellPhone;

	private LocalDate birth;
}
