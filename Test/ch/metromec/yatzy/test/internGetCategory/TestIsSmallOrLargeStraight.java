package ch.metromec.yatzy.test.internGetCategory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.internGetCategory.IsSmallOrLargeStraight;

public class TestIsSmallOrLargeStraight {
	Roll aRoll;
	IsSmallOrLargeStraight aIsSmallOrLargeStraight;

	@Before
	public void setUp() throws Exception {
		aRoll = new Roll();
		aIsSmallOrLargeStraight = new IsSmallOrLargeStraight();
	}

	/**
	 * Help method to add points to the given roll
	 * 
	 * @param pointsList
	 */
	private void addPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			aRoll.SetRollPoints(i, pointsList[i]);
		}
	}

	@Test
	public void testIsLargeStraight() {
		addPoints(1, 2, 3, 4, 5);
		assertEquals(11, aIsSmallOrLargeStraight.getCategory(aRoll));
	}

	@Test
	public void testIsLargeStraight2() {
		addPoints(2, 3, 4, 5, 6);
		assertEquals(11, aIsSmallOrLargeStraight.getCategory(aRoll));
	}

	@Test
	public void testIsSmallStraight() {
		addPoints(2, 3, 4, 4, 5);
		assertEquals(10, aIsSmallOrLargeStraight.getCategory(aRoll));
	}

	@Test
	public void testIsSmallStraight1() {
		addPoints(1, 2, 3, 4, 6);
		assertEquals(10, aIsSmallOrLargeStraight.getCategory(aRoll));
	}

	@Test
	public void testIsSmallStraight2() {
		addPoints(2, 3, 4, 5, 5);
		assertEquals(10, aIsSmallOrLargeStraight.getCategory(aRoll));
	}

	@Test
	public void testIsSmallStraightWrong() {
		addPoints(1, 3, 4, 5, 5);
		assertEquals(0, aIsSmallOrLargeStraight.getCategory(aRoll));
	}

}
