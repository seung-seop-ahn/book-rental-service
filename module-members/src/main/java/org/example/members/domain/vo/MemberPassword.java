package org.example.members.domain.vo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Value;

@Value
public class MemberPassword {

	String password;

	public MemberPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}
}
