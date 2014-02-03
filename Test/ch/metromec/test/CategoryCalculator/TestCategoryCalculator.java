package ch.metromec.test.CategoryCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.YatzyConstants;
import ch.metromec.yatzy.categoryCalculator.CategoryCalculator;

public class TestCategoryCalculator {
	Roll aRoll;
	CategoryCalculator aCategoryCalculator;

	@Before
	public void setUp() throws Exception {
		aRoll = new Roll();
		aCategoryCalculator = new CategoryCalculator();
	}

	private void addPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			aRoll.SetRollPoints(i, pointsList[i]);
		}
	}

	@Test
	public void testIsAOnes() {
		addPoints(1, 1, 2, 3, 5);
		assertEquals(YatzyConstants.ONES, aCategoryCalculator.calculateCategory("Ones", aRoll));
	}

	@Test
	public void testIsAThrees() {
		addPoints(3, 3, 4, 6, 5);
		assertEquals(YatzyConstants.THREES, aCategoryCalculator.calculateCategory("Threes", aRoll));
	}

	@Test
	public void testIsAYatzy() {
		addPoints(3, 3, 3, 3, 3);
		assertEquals(YatzyConstants.YATHZEE,
				aCategoryCalculator.calculateCategory("Yahtzee", aRoll));
	}

	@Test
	public void testIsFourOfAkind() {
		addPoints(1, 3, 3, 3, 3);
		assertEquals(YatzyConstants.FOUR_OF_A_KIND,
				aCategoryCalculator.calculateCategory("FourOfAKind", aRoll));
	}

	@Test
	public void testNullRoll() {
		assertEquals(YatzyConstants.ZERO,
				aCategoryCalculator.calculateCategory("FourOfAKind", null));
	}
}
