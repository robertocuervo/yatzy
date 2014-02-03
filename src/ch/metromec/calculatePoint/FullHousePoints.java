package ch.metromec.calculatePoint;

import ch.metromec.calculatePoints.contract.ICalculatePoints;
import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;

public class FullHousePoints implements ICalculatePoints {

	@Override
	public int getRollPointsWithCategoryIndex(Roll aRoll, int categoryIndex) {
		int count = YatzyConstants.ONES;
		boolean bTwoSame = false, bThreeSame = false;
		if (aRoll != null) {
			for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
				if (aRoll.GetRollPoints(i) == aRoll.GetRollPoints(i - YatzyConstants.ONES)) {
					count++;
					if (((count == YatzyConstants.THREES) && (i == YatzyConstants.TWOS))
							|| ((count == YatzyConstants.THREES) && (i == YatzyConstants.FOURS))) {
						bThreeSame = true;
					} else if (((count == YatzyConstants.TWOS) && (i == YatzyConstants.ONES))
							|| ((count == YatzyConstants.TWOS) && (i == YatzyConstants.FOURS))) {
						bTwoSame = true;
						count = YatzyConstants.ONES;
					}
				}
			}
		}
		if (bThreeSame && bTwoSame)
			return YatzyConstants.FULL_HOUSE_POINTS;
		return YatzyConstants.ZERO;
	}
}