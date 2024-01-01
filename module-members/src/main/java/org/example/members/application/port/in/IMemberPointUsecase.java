package org.example.members.application.port.in;

public interface IMemberPointUsecase {
	void addRewardPoint(Long memberId);

	void addPenaltyPoint(Long memberId);

	void removePenaltyPoint(Long memberId);
}
