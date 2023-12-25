package org.example.members.adapter.out.persistence.adapter;

import org.example.common.annotation.service.PersistenceAdapter;
import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.adapter.out.persistence.mapper.MemberMapper;
import org.example.members.adapter.out.persistence.orm.MemberRepository;
import org.example.members.application.port.out.IRegisterMemberPort;
import org.example.members.domain.Member;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements IRegisterMemberPort {

	private final MemberRepository memberRepository;

	@Override
	public Member create(Member member) {
		MemberEntity entity = MemberMapper.toEntity(member);
		MemberEntity saved = this.memberRepository.save(entity);
		return MemberMapper.toDomain(saved);
	}
}
