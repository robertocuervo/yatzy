package ch.metromec.yatzy.categoryCalculator;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.categoryCalculator.contract.ICategoryCalculator;
import ch.metromec.yatzy.internGetCategory.CategoryFactory;
import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class CategoryCalculator implements ICategoryCalculator {

	@Override
	public int calculateCategory(String methodName, Roll p_aRoll) {
		int categoryIndex = YatzyConstants.ZERO;
		IInternGetCategory aCategoryGetter;
		if ((methodName == null) || (p_aRoll == null))
			return categoryIndex;
		aCategoryGetter = CategoryFactory.getCategory(methodName);
		if (aCategoryGetter != null) {
			categoryIndex = aCategoryGetter.getCategory(p_aRoll);
			return categoryIndex;
		}
		return YatzyConstants.ZERO;
	}
}
