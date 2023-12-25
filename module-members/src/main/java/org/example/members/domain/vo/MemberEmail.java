package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberEmail {

	String email;

	public MemberEmail(String email) {
		this.email = email;
	}
}
