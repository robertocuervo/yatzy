package ch.metromec.yatzy.test.internGetCategory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.internGetCategory.IsFullHouse;

public class TestIsFullHouse {
	Roll aRoll;
	IsFullHouse aIsFullHouse;

	@Before
	public void setUp() throws Exception {
		aRoll = new Roll();
		aIsFullHouse = new IsFullHouse();
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
	public void testGetCategory1() {
		addPoints(1, 1, 3, 3, 3);
		assertEquals(12, aIsFullHouse.getCategory(aRoll));
	}

	@Test
	public void testGetCategory2() {
		addPoints(1, 1, 1, 3, 3);
		assertEquals(12, aIsFullHouse.getCategory(aRoll));
	}

	@Test
	public void testGetCategory3() {
		addPoints(1, 2, 3, 3, 3);
		assertEquals(0, aIsFullHouse.getCategory(aRoll));
	}
}
