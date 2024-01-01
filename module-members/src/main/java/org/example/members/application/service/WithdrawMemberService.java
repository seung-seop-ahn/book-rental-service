package org.example.members.application.service;

import org.example.common.annotation.service.Usecase;
import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.application.port.in.IWithdrawMemberUsecase;
import org.example.members.application.port.out.IFindMemberPort;
import org.example.members.domain.vo.MemberStatus;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
@Transactional
public class WithdrawMemberService implements IWithdrawMemberUsecase {

	private final IFindMemberPort findMemberPort;

	@Override
	public void withdraw(Long memberId) {
		MemberEntity entity = this.findMemberPort.findEntityById(memberId);
		if (entity.getPenaltyPoint() > 0) {
			throw new IllegalArgumentException("invalid penalty point");
		}

		entity.setStatus(MemberStatus.withdraw);
	}
}
