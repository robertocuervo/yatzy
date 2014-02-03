package ch.metromec.calculatePoint;

import ch.metromec.calculatePoints.contract.ICalculatePoints;
import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;

public class CalculateOnesToSixesPoints implements ICalculatePoints {

	@Override
	public int getRollPointsWithCategoryIndex(Roll aRoll, int categoryIndex) {
		int score = 0;
		int count = YatzyConstants.ONES;
		if (aRoll != null)
			for (int i = 0; i < 5; i++) {
				if (aRoll.GetRollPoints(i) == categoryIndex) {
					count++;
					score += aRoll.GetRollPoints(i);
				}
			}
		if ((count >= YatzyConstants.TWOS) && (count <= YatzyConstants.FIVES)) {
			return score;
		} else {
			return 0;
		}
	}

}
