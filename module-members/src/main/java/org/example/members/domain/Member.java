package org.example.members.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.example.members.domain.vo.MemberAddress;
import org.example.members.domain.vo.MemberBirth;
import org.example.members.domain.vo.MemberCellPhone;
import org.example.members.domain.vo.MemberEmail;
import org.example.members.domain.vo.MemberId;
import org.example.members.domain.vo.MemberName;
import org.example.members.domain.vo.MemberPassword;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Member {
	private MemberId id;

	private MemberEmail email;

	private MemberPassword password;

	private MemberName name;

	private MemberAddress address;

	private MemberCellPhone cellPhone;

	private MemberBirth birth;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public static Member create(
		String email,
		String password,
		String name,
		String zipcode,
		String address1,
		String address2,
		String cellPhone,
		LocalDate birth
	) {
		return new Member(
			new MemberId(0L),
			new MemberEmail(email),
			new MemberPassword(password),
			new MemberName(name),
			new MemberAddress(zipcode, address1, address2),
			new MemberCellPhone(cellPhone),
			new MemberBirth(birth),
			LocalDateTime.now(),
			LocalDateTime.now()
		);
	}

	public static Member from(
		Long id,
		String email,
		String password,
		String name,
		String zipcode,
		String address1,
		String address2,
		String cellPhone,
		LocalDate birth,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	) {
		return new Member(
			new MemberId(id),
			new MemberEmail(email),
			new MemberPassword(password, true),
			new MemberName(name),
			new MemberAddress(zipcode, address1, address2),
			new MemberCellPhone(cellPhone),
			new MemberBirth(birth),
			createdAt,
			updatedAt
		);
	}
}
