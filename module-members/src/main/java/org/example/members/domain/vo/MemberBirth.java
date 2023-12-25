package org.example.members.domain.vo;

import java.time.LocalDate;

import lombok.Value;

@Value
public class MemberBirth {

	LocalDate birth;

	public MemberBirth(LocalDate birth) {
		this.birth = birth;
	}
}
