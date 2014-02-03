package ch.metromec.calculatePoint;

import ch.metromec.calculatePoints.contract.ICalculatePoints;
import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;

public class SumAllRollPoints implements ICalculatePoints {

	@Override
	public int getRollPointsWithCategoryIndex(Roll aRoll, int categoryIndex) {

		if (categoryIndex == YatzyConstants.YATHZEE) {
			if (isKindOf(aRoll, YatzyConstants.FIVES))
				return YatzyConstants.YATHZEE_POINTS;
			return 0;
		} else if (isKindOf(aRoll, YatzyConstants.THREES)) {
			return aRoll.SumAllRollPoints();
		} else if (isKindOf(aRoll, YatzyConstants.FOURS)) {
			return aRoll.SumAllRollPoints();
		} else if (categoryIndex == YatzyConstants.CHANCE) {
			return aRoll.SumAllRollPoints();
		} else {
			return 0;
		}
	}

	private boolean isKindOf(Roll p_aRoll, int category) {
		int count = YatzyConstants.ONES;
		boolean isKindOf = false;
		for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
			if (p_aRoll.GetRollPoints(i) == p_aRoll.GetRollPoints(i - YatzyConstants.ONES)) {
				count++;
				isKindOf = ((count >= 3) && (count == category));
			} else {
				count = 1;
			}
		}
		return isKindOf;
	}
}
