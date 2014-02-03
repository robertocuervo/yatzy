package ch.metromec.test.yatzy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.Roll;

public class TestRoll {
	private Roll aRoll;

	@Before
	public void setUp() {
		aRoll = new Roll();
	}

	private void addAndCheckPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			aRoll.SetRollPoints(i, pointsList[i]);
			assertEquals(pointsList[i], aRoll.GetRollPoints(i));
		}
	}

	private void addPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			aRoll.SetRollPoints(i, pointsList[i]);
		}
	}

	private void checkPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			assertEquals(pointsList[i], aRoll.GetRollPoints(i));
		}
	}

	@Test
	public void testAddOnes() {
		addAndCheckPoints(1, 1, 1, 1, 1);
	}

	@Test
	public void testAddSomePoints() {
		addAndCheckPoints(3, 5, 5, 6, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPointsLowerBounding() {
		addAndCheckPoints(1, 1, 1, -10, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPointsUpperBounding() {
		addAndCheckPoints(1, 1, 10, 1, 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPointsWrongUperIndex() {
		aRoll.SetRollPoints(7, 6);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetPointsWrongUperIndex() {
		aRoll.GetRollPoints(7);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetPointsWrongLowerBounding() {
		aRoll.GetRollPoints(-13);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddPointsWrongLowerIndex() {
		aRoll.SetRollPoints(-1, 6);
	}

	@Test
	public void testOrderRoll() {
		addPoints(5, 4, 3, 1, 2);
		aRoll.orderRollPoints();
		checkPoints(1, 2, 3, 4, 5);
	}

	@Test
	public void testSumAllRollPoints() {
		addPoints(5, 4, 3, 1, 2);
		assertEquals(15, aRoll.SumAllRollPoints());
	}

	@Test
	public void testRandomPoints() {
		aRoll.FillRollWithRandomPoints();
		aRoll.orderRollPoints();
		// aRoll.PrintRoll();
	}
}
