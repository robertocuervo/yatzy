package ch.metromec.yatzy.internGetCategory;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class IsYathzeeOrKindOf implements IInternGetCategory {
	@Override
	public int getCategory(Roll p_aRoll) {
		if (IsEinPaschOderYatzy(p_aRoll, 3)) {
			return 7;
		} else if (IsEinPaschOderYatzy(p_aRoll, 4)) {
			return 8;
		} else if (IsEinPaschOderYatzy(p_aRoll, 5)) {
			return 9;
		} else {
			return 0;
		}
	}

	private boolean IsEinPaschOderYatzy(Roll p_aRoll, int category) {
		int count = YatzyConstants.ONES;
		boolean isSomething = false;
		for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
			if (p_aRoll.GetRollPoints(i) == p_aRoll.GetRollPoints(i - YatzyConstants.ONES)) {
				count++;
				isSomething = ((count >= 3) && (count == category));
			} else {
				count = 1;
			}
		}
		return isSomething;
	}
}
