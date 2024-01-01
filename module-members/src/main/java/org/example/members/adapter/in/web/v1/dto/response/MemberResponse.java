package org.example.members.adapter.in.web.v1.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.example.members.domain.Member;

import lombok.Value;

@Value
public class MemberResponse {

	Long id;

	String email;

	String name;

	String zipcode;

	String address1;

	String address2;

	String cellPhone;

	LocalDate birth;

	LocalDateTime createdAt;

	LocalDateTime updatedAt;

	public static MemberResponse from(Member member) {
		return new MemberResponse(
			member.getId().getId(),
			member.getEmail().getEmail(),
			member.getName().getName(),
			member.getAddress().getZipcode(),
			member.getAddress().getAddress1(),
			member.getAddress().getAddress2(),
			member.getCellPhone().getCellPhone(),
			member.getBirth().getBirth(),
			member.getCreatedAt(),
			member.getUpdatedAt()
		);
	}

}
