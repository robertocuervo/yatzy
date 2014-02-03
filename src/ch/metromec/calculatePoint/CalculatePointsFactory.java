package ch.metromec.calculatePoint;

import ch.metromec.calculatePoints.contract.ICalculatePoints;
import ch.metromec.yatzy.YatzyConstants;

public class CalculatePointsFactory {

	public static ICalculatePoints getCategoryForPointsCalculating(int categoryIndex) {

		if ((categoryIndex >= 1) && (categoryIndex <= 13)) {
			switch (categoryIndex) {
			case YatzyConstants.ONES:
			case YatzyConstants.TWOS:
			case YatzyConstants.THREES:
			case YatzyConstants.FOURS:
			case YatzyConstants.FIVES:
			case YatzyConstants.SIXES:
				return new CalculateOnesToSixesPoints();
			case YatzyConstants.THREEE_OF_A_KIND:
			case YatzyConstants.FOUR_OF_A_KIND:
			case YatzyConstants.YATHZEE:
				return new SumAllRollPoints();
			case YatzyConstants.SMALL_STRAIGHT:
				return new SmallStraightPoints();
			case YatzyConstants.LARGE_STRAIGHT:
				return new LargeStraightPoints();
			case YatzyConstants.FULL_HOUSE:
				return new FullHousePoints();
			case YatzyConstants.CHANCE:
				return new SumAllRollPoints();
			default:
				return null;
			}
		}
		return null;

	}

}
