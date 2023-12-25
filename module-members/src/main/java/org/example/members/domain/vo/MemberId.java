package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberId {

	Long id;

	public MemberId(Long id) {
		this.id = id;
	}
}
