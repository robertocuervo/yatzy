package ch.metromec.calculatePoint;

import ch.metromec.calculatePoints.contract.ICalculatePoints;
import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;

public class SmallStraightPoints implements ICalculatePoints {

	@Override
	public int getRollPointsWithCategoryIndex(Roll aRoll, int categoryIndex) {

		if (aRoll != null) {
			int inLine = YatzyConstants.ONES;
			for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
				if ((aRoll.GetRollPoints(i - 1) + 1) == aRoll.GetRollPoints(i))
					inLine++;
			}
			if (inLine == YatzyConstants.FOURS) {
				return YatzyConstants.SMALL_STRAIGHT_POINTS;
			} else {
				return YatzyConstants.ZERO;
			}
		}
		return YatzyConstants.ZERO;
	}
}