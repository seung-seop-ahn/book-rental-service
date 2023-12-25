package org.example.members.application.port.in;

import org.example.members.application.port.in.command.RegisterMemberCommand;
import org.example.members.domain.vo.MemberId;

public interface IRegisterMemberUsecase {

	MemberId register(RegisterMemberCommand command);
}
