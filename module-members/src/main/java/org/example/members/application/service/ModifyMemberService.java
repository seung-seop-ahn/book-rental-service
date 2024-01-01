package org.example.members.application.service;

import java.time.LocalDateTime;

import org.example.common.annotation.service.Usecase;
import org.example.members.adapter.in.web.v1.dto.response.MemberResponse;
import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.adapter.out.persistence.mapper.MemberMapper;
import org.example.members.application.port.in.IModifyMemberUsecase;
import org.example.members.application.port.in.command.ModifyMemberCommand;
import org.example.members.application.port.out.IFindMemberPort;
import org.example.members.application.port.out.IModifyMemberPort;
import org.example.members.domain.Member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
@Transactional
public class ModifyMemberService implements IModifyMemberUsecase {

	private final IFindMemberPort findMemberPort;
	private final IModifyMemberPort modifyMemberPort;

	@Override
	public MemberResponse modify(Long memberId, ModifyMemberCommand command) {
		MemberEntity entity = this.findMemberPort.findEntityById(memberId);

		// dirty check
		entity.setName(command.getName());
		entity.setZipcode(command.getZipcode());
		entity.setAddress1(command.getAddress1());
		entity.setAddress2(command.getAddress2());
		entity.setCellPhone(command.getCellPhone());
		entity.setBirth(command.getBirth());

		Member member = MemberMapper.toDomain(entity);

		return MemberResponse.from(member);
	}

	@Override
	public MemberResponse save(Long memberId, ModifyMemberCommand command) {
		Member member = this.findMemberPort.findById(memberId);

		Member newMember = Member.from(
			member.getId().getId(),
			member.getEmail().getEmail(),
			member.getPassword().getPassword(),
			command.getName(),
			command.getZipcode(),
			command.getAddress1(),
			command.getAddress2(),
			command.getCellPhone(),
			command.getBirth(),
			member.getCreatedAt(),
			LocalDateTime.now()
		);

		Member updatedMember = this.modifyMemberPort.modify(newMember);

		return MemberResponse.from(updatedMember);
	}
}
