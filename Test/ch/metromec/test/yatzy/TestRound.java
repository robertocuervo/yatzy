package ch.metromec.test.yatzy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.Round;
import ch.metromec.yatzy.Roll;

public class TestRound {
	private Roll aRoll;
	private Round aRound;

	@Before
	public void setUp() {
		aRoll = new Roll();
		aRound = new Round(1);
	}

	private void addPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			aRoll.SetRollPoints(i, pointsList[i]);
		}
	}

	// private void addAndCheckPoints(int... pointsList) {
	// for (int i = 0; i < 5; i++) {
	// aRoll.SetRollPoints(i, pointsList[i]);
	// assertEquals(pointsList[i], aRoll.GetRollPoints(i));
	// }
	// }

	private void checkPoints(int... pointsList) {
		for (int i = 0; i < 5; i++) {
			assertEquals(pointsList[i], aRoll.GetRollPoints(i));
		}
	}

	@Test
	public void testAddRoll() {
		addPoints(1, 1, 1, 1, 1);
		aRound.addRoll(0, aRoll);
		aRoll = aRound.getRoll(0);
		checkPoints(1, 1, 1, 1, 1);
		assertNotNull(aRoll);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNullRoll() {
		aRound.addRoll(0, null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddRollLowBoundig() {
		aRound.addRoll(-1, aRoll);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddRollUpperBoundig() {
		aRound.addRoll(14, aRoll);
	}

	@Test
	public void testGetRoll() {
		Roll roll;
		aRound.startRound();
		roll = aRound.getRoll(1);
		assertNotNull(roll);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetRollLowBounding() {
		aRound.getRoll(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetRollpperBounding() {
		aRound.getRoll(13);
	}

}
