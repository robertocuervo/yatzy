package ch.metromec.yatzy.internGetCategory;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class IsChance implements IInternGetCategory {

	@Override
	public int getCategory(Roll p_aRoll) {
		return YatzyConstants.CHANCE;
	}
}
