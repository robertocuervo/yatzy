package ch.metromec.yatzy.internGetCategory;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class IsFullHouse implements IInternGetCategory {

	@Override
	public int getCategory(Roll p_aRoll) {
		int count = YatzyConstants.ONES;
		boolean bTwoSame = false, bThreeSame = false;
		if (p_aRoll != null) {

			for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
				if (p_aRoll.GetRollPoints(i) == p_aRoll.GetRollPoints(i - YatzyConstants.ONES)) {
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
			return YatzyConstants.FULL_HOUSE;
		return YatzyConstants.ZERO;
	}
}