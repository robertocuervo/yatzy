package ch.metromec.yatzy.categoryCalculator.contract;

import ch.metromec.yatzy.Roll;

public interface ICategoryCalculator {
	public int calculateCategory(String methodName, Roll aRoll);
}
