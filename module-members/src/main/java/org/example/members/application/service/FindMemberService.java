package org.example.members.application.service;

import org.example.common.annotation.service.Usecase;
import org.example.members.adapter.in.web.v1.dto.response.MemberResponse;
import org.example.members.application.port.in.IFindMemberUsecase;
import org.example.members.application.port.out.IFindMemberPort;
import org.example.members.domain.Member;

import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class FindMemberService implements IFindMemberUsecase {

	private final IFindMemberPort findMemberPort;

	@Override
	public MemberResponse findById(Long memberId) {
		Member member = this.findMemberPort.findById(memberId);
		return MemberResponse.from(member);
	}
}
