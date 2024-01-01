package org.example.members.application.port.in;

import org.example.members.adapter.in.web.v1.dto.response.MemberResponse;
import org.example.members.application.port.in.command.ModifyMemberCommand;

public interface IModifyMemberUsecase {

	MemberResponse modify(Long memberId, ModifyMemberCommand command);

	MemberResponse save(Long memberId, ModifyMemberCommand command);
}
