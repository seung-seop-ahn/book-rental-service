package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberName {

	String name;

	public MemberName(String name) {
		this.name = name;
	}
}
