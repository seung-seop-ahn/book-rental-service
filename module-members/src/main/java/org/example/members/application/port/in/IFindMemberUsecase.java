package org.example.members.application.port.in;

import org.example.members.adapter.in.web.v1.dto.response.MemberResponse;

public interface IFindMemberUsecase {

	MemberResponse findById(Long memberId);
}
