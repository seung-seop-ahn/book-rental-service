package org.example.members.domain.vo;

import lombok.Value;

@Value
public class MemberPoints {

	int rewardPoint;
	int penaltyPoint;

	public MemberPoints(int rewardPoint, int penaltyPoint) {
		this.rewardPoint = rewardPoint;
		this.penaltyPoint = penaltyPoint;
	}
}
