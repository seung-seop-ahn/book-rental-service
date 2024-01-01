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

	public MemberPoints addRewardPoint(int rewardPoint) {
		return new MemberPoints(this.rewardPoint + rewardPoint, this.penaltyPoint);
	}

	public MemberPoints addPenaltyPoint(int penaltyPoint) {
		return new MemberPoints(this.rewardPoint, this.penaltyPoint + penaltyPoint);
	}

	public MemberPoints removePenaltyPoint() {
		int remainRewardPoint = this.rewardPoint - this.penaltyPoint;
		return remainRewardPoint < 0
			? new MemberPoints(0, Math.abs(remainRewardPoint))
			: new MemberPoints(remainRewardPoint, 0);
	}
}
