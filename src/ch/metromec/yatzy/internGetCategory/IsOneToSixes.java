package ch.metromec.yatzy.internGetCategory;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class IsOneToSixes implements IInternGetCategory {

	@Override
	public int getCategory(Roll p_aRoll) {
		int count = YatzyConstants.ONES;
		int category = YatzyConstants.ZERO;
		if (p_aRoll != null)
			for (int i = YatzyConstants.ONES; i <= YatzyConstants.FOURS; i++) {
				if (p_aRoll.GetRollPoints(i) == p_aRoll.GetRollPoints(i - 1)) {
					count++;
					if ((count >= YatzyConstants.TWOS) && (count <= YatzyConstants.FOURS)) {
						// category = p_aRoll.GetRollPoints(i);
						return p_aRoll.GetRollPoints(i);
					}
				}
				// else {
				// count = YatzyConstants.ONE;
				// }
			}
		return category;

	}
}