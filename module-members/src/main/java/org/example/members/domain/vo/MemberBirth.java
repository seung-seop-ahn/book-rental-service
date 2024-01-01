package org.example.members.domain.vo;

import java.time.LocalDate;
import java.time.Period;

import lombok.Value;

@Value
public class MemberBirth {

	LocalDate birth;

	public MemberBirth(LocalDate birth) {
		LocalDate now = LocalDate.now();
		
		int age = Period.between(birth, now).getYears();
		if(age < 18) {
			throw new IllegalArgumentException("invalid age");
		}

		this.birth = birth;
	}
}
