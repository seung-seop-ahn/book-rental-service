package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberAddress {

	String zipcode;

	String address1;

	String address2;

	public MemberAddress(String zipcode, String address1, String address2) {
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}
}
