package org.example.members.application.port.in;

import org.example.members.application.port.in.command.RegisterMemberCommand;

public interface IRegisterMemberUsecase {

	String register(RegisterMemberCommand command);
}
