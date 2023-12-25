package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberPassword {

	String password;

	public MemberPassword(String password) {
		// todo: bcrypt
		this.password = password;
	}
}
