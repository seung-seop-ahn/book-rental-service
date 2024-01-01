package org.example.members.adapter.out.persistence.mapper;

import org.example.members.adapter.out.persistence.entity.MemberEntity;
import org.example.members.domain.Member;

public class MemberMapper {

	public static MemberEntity toEntity(Member member) {
		return new MemberEntity(
			member.getId().getId(),
			member.getEmail().getEmail(),
			member.getPassword().getPassword(),
			member.getName().getName(),
			member.getAddress().getZipcode(),
			member.getAddress().getAddress1(),
			member.getAddress().getAddress2(),
			member.getCellPhone().getCellPhone(),
			member.getBirth().getBirth(),
			member.getStatus(),
			member.getCreatedAt(),
			member.getUpdatedAt()
		);
	}

	public static Member toDomain(MemberEntity entity) {
		return Member.from(
			entity.getId(),
			entity.getEmail(),
			entity.getPassword(),
			entity.getName(),
			entity.getZipcode(),
			entity.getAddress1(),
			entity.getAddress2(),
			entity.getCellPhone(),
			entity.getBirth(),
			entity.getStatus(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
