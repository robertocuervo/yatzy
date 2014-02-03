package ch.metromec.yatzy.test.internGetCategory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.internGetCategory.IsOneToSixes;

public class TestIsOneToSixes {
	Roll aRoll;
	IsOneToSixes aIsOneToSixes;

	@Before
	public void setUp() throws Exception {
		aRoll = new Roll();
		aIsOneToSixes = new IsOneToSixes();
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
	public void testIsOnes() {
		addPoints(1, 1, 2, 2, 4);
		assertEquals(1, aIsOneToSixes.getCategory(aRoll));
	}

	@Test
	public void testIsOnes2() {
		addPoints(1, 1, 1, 3, 4);
		assertEquals(1, aIsOneToSixes.getCategory(aRoll));
	}

	@Test
	public void testIsOnes3() {
		addPoints(1, 1, 1, 1, 4);
		assertEquals(1, aIsOneToSixes.getCategory(aRoll));
	}

	@Test
	public void testIsTwos1() {
		addPoints(1, 2, 2, 3, 4);
		assertEquals(2, aIsOneToSixes.getCategory(aRoll));
	}

	@Test
	public void testIsThrees() {
		addPoints(1, 2, 3, 3, 4);
		assertEquals(3, aIsOneToSixes.getCategory(aRoll));
	}

	@Test
	public void testIsSixes() {
		addPoints(1, 2, 3, 6, 6);
		assertEquals(6, aIsOneToSixes.getCategory(aRoll));
	}
}
