package org.example.members.application.service;

import org.example.common.annotation.service.Usecase;
import org.example.members.application.port.out.IValidateMemberPort;

import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class ValidateMemberService {

	private final IValidateMemberPort validateMemberPort;

	public void isEmailExist(String email) {
		boolean isExist = this.validateMemberPort.isEmailExist(email);
		if (isExist) {
			throw new IllegalArgumentException("invalid email");
		}
	}
}
