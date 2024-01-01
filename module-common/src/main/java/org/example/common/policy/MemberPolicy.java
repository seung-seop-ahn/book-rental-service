package org.example.common.policy;

public class MemberPolicy {
	public static boolean cellPhone(String value) {
		return value.matches("(01[016789])(\\d{3,4})(\\d{4})");
	}
}
