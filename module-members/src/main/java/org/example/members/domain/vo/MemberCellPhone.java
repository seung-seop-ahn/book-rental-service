package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberCellPhone {

	String cellPhone;

	public MemberCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
}
