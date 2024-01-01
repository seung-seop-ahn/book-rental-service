package org.example.members.application.port.out;

import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.domain.Member;

public interface IFindMemberPort {
	Member findById(Long memberId);

	MemberEntity findEntityById(Long memberId);
}
