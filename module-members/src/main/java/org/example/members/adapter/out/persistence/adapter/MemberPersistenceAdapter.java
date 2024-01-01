package org.example.members.adapter.out.persistence.adapter;

import org.example.common.annotation.service.PersistenceAdapter;
import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.adapter.out.persistence.mapper.MemberMapper;
import org.example.members.adapter.out.persistence.orm.MemberRepository;
import org.example.members.application.port.out.IFindMemberPort;
import org.example.members.application.port.out.IModifyMemberPort;
import org.example.members.application.port.out.IRegisterMemberPort;
import org.example.members.application.port.out.IValidateMemberPort;
import org.example.members.domain.Member;

import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter
	implements IValidateMemberPort, IRegisterMemberPort, IFindMemberPort, IModifyMemberPort {

	private final MemberRepository memberRepository;

	@Override
	public boolean isEmailExist(String email) {
		return this.memberRepository.existsByEmail(email);
	}

	@Override
	public Member create(Member member) {
		MemberEntity entity = MemberMapper.toEntity(member);
		MemberEntity saved = this.memberRepository.save(entity);
		return MemberMapper.toDomain(saved);
	}

	@Override
	public Member findById(Long memberId) {
		MemberEntity entity = this.memberRepository.findById(memberId)
			.orElseThrow(() -> new IllegalArgumentException("not found"));
		return MemberMapper.toDomain(entity);
	}

	@Override
	public MemberEntity findEntityById(Long memberId) {
		return this.memberRepository.findById(memberId)
			.orElseThrow(() -> new IllegalArgumentException("not found"));
	}

	@Override
	public Member modify(Member member) {
		// todo: save
		MemberEntity entity = MemberMapper.toEntity(member);
		MemberEntity saved = this.memberRepository.save(entity);
		return MemberMapper.toDomain(saved);
	}
}
