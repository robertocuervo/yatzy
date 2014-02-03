package ch.metromec.calculatePoints.contract;

import ch.metromec.yatzy.Roll;

public interface ICalculatePoints {
	public int getRollPointsWithCategoryIndex(Roll aRoll, int categoryIndex);
}
