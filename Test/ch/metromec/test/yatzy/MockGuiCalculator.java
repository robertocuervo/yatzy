package ch.metromec.test.yatzy;

import ch.metromec.test.mockgui.contract.IMockGui;

public class MockGuiCalculator implements IMockGui {
	public int userCategoryInput;

	@Override
	public int getCategoryIndexFromUser() {
		return userCategoryInput;
	}

}
