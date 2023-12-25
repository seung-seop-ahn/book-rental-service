package org.example.members.application.port.out;

import org.example.members.domain.Member;

public interface IRegisterMemberPort {
	Member create(Member member);
}
