package org.example.members.domain.vo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Value;

@Value
public class MemberPassword {

	String password;

	public MemberPassword(String password) {
		this.password = this.encrypt(password);
	}

	public MemberPassword(String password, boolean isEncrypted) {
		this.password = isEncrypted ? password : this.encrypt(password);
	}

	public String encrypt(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
