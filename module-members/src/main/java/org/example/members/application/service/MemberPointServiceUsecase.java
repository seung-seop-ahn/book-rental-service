package org.example.members.application.service;

import org.example.common.annotation.service.Usecase;
import org.example.members.application.port.in.IMemberPointUsecase;
import org.example.members.application.port.out.IFindMemberPort;
import org.example.members.application.port.out.IModifyMemberPort;
import org.example.members.domain.Member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
@Transactional
public class MemberPointServiceUsecase implements IMemberPointUsecase {

	private final IFindMemberPort findMemberPort;
	private final IModifyMemberPort modifyMemberPort;

	@Override
	public void addRewardPoint(Long memberId) {
		Member member = this.findMemberPort.findById(memberId);
		member.addRewardPoint(10);
		this.modifyMemberPort.modify(member);
	}

	@Override
	public void addPenaltyPoint(Long memberId) {
		Member member = this.findMemberPort.findById(memberId);
		member.addPenaltyPoint(10);
		this.modifyMemberPort.modify(member);
	}

	@Override
	public void removePenaltyPoint(Long memberId) {
		Member member = this.findMemberPort.findById(memberId);
		member.removePenaltyPoint();
		this.modifyMemberPort.modify(member);
	}
}
