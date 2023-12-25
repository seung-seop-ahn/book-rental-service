package org.example.members.application.service;

import org.example.common.annotation.service.Usecase;
import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.application.port.in.IRegisterMemberUsecase;
import org.example.members.application.port.in.command.RegisterMemberCommand;
import org.example.members.application.port.out.IRegisterMemberPort;
import org.example.members.domain.Member;
import org.example.members.domain.vo.MemberId;

import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class RegisterMemberService implements IRegisterMemberUsecase {

	private final IRegisterMemberPort registerMemberPort;

	@Override
	public MemberId register(RegisterMemberCommand command) {
		Member member = Member.create(
			command.getEmail(),
			command.getPassword(),
			command.getName(),
			command.getZipCode(),
			command.getAddress1(),
			command.getAddress2(),
			command.getCellPhone(),
			command.getBirth()
		);

		Member saved = this.registerMemberPort.create(member);
		return saved.getId();
	}
}
