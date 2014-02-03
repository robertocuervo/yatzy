package ch.metromec.yatzy;

import java.util.ArrayList;

/**
 * Contains a <tt>boolean</tt> list which stores each category status (free =
 * <tt>true</tt>, occupied = <tt>false</tt>), check the status and change it if
 * needed.
 * @author RCu
 * 
 */
public class CategoriesComparator {

	private ArrayList<Boolean> categoriesStatusList = new ArrayList<>();

	/**
	 * Fills the status list with default values (true) .
	 */
	public void intializeList() {
		for (int i = YatzyConstants.ZERO; i < YatzyConstants.CHANCE; i++) {
			this.categoriesStatusList.add(i, true);
		}
	}

	public boolean isCategoryFree(int p_index) {
		if ((p_index < YatzyConstants.ZERO) || (p_index > YatzyConstants.CHANCE))
			throw new IndexOutOfBoundsException();

		return categoriesStatusList.get(p_index);
	}

	public void markAsOccupied(int p_index) {
		if ((p_index < YatzyConstants.ZERO) || (p_index > YatzyConstants.CHANCE))
			throw new IndexOutOfBoundsException();

		categoriesStatusList.set(p_index, false);
	}

}
