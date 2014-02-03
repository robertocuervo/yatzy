package ch.metromec.yatzy;

import java.util.ArrayList;

import ch.metromec.yatzy.categoryCalculator.CategoryCalculator;

/**
 * Gets from the given Roll all the possible categories to which the Roll can
 * belong and return them in a <code>Integer ArrayList</code>. For example,
 * <tt>1</tt> means the <tt>Ones</tt> category, or <tt>13</tt> the
 * <tt>Chance</tt> category.
 * 
 * @author RCu
 * @see YatzyConstants
 * 
 */
public abstract class CategoryGetter {
	/**
	 * Returns the categories to which the given Roll belongs
	 * 
	 * @param Roll to be checked
	 * @return ArrayList Integer
	 * @see CategoryGetter class description
	 */
	public static ArrayList<Integer> getCategories(Roll p_aRoll) {
		int categoryIndex = YatzyConstants.ZERO;
		ArrayList<Integer> categories = new ArrayList<>();
		for (String methodName : YatzyConstants.categoriesNames) {
			categoryIndex = CalculateCategoryIndex(methodName, p_aRoll);
			if ((categoryIndex != YatzyConstants.ZERO) && (!categories.contains(categoryIndex)))
				categories.add(categoryIndex);
		}
		return categories;
	}

	private static int CalculateCategoryIndex(String methodName, Roll p_aRoll) {
		if ((methodName == null) || (p_aRoll == null))
			return YatzyConstants.ZERO;
		CategoryCalculator categoryCalculator = new CategoryCalculator();
		return categoryCalculator.calculateCategory(methodName, p_aRoll);
	}
}
