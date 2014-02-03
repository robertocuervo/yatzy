package ch.metromec.yatzy.internGetCategory;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class IsSmallOrLargeStraight implements IInternGetCategory {

	@Override
	public int getCategory(Roll p_aRoll) {
		if (p_aRoll != null) {
			int inLine = YatzyConstants.ONES;
			for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
				if ((p_aRoll.GetRollPoints(i - 1) + 1) == p_aRoll.GetRollPoints(i))
					inLine++;
			}
			switch (inLine) {
			case YatzyConstants.FOURS:
				return YatzyConstants.SMALL_STRAIGHT;
			case YatzyConstants.FIVES:
				return YatzyConstants.LARGE_STRAIGHT;
			default:
				return YatzyConstants.ZERO;
			}
		}
		return YatzyConstants.ZERO;
	}
}
