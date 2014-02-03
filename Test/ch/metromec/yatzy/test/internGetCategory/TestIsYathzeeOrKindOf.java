package ch.metromec.yatzy.test.internGetCategory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.internGetCategory.IsYathzeeOrKindOf;

public class TestIsYathzeeOrKindOf {
	Roll aRoll;
	IsYathzeeOrKindOf aIsYathzeeOrKindOf;

	@Before
	public void setUp() throws Exception {
		aRoll = new Roll();
		aIsYathzeeOrKindOf = new IsYathzeeOrKindOf();
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
	public void testIsYatzy() {
		addPoints(5, 5, 5, 5, 5);
		assertEquals(9, aIsYathzeeOrKindOf.getCategory(aRoll));
	}

	@Test
	public void testIsFourOfAKind() {
		addPoints(5, 5, 5, 5, 6);
		assertEquals(8, aIsYathzeeOrKindOf.getCategory(aRoll));
	}

	@Test
	public void testIsFourOfAKind2() {
		addPoints(1, 5, 5, 5, 5);
		assertEquals(8, aIsYathzeeOrKindOf.getCategory(aRoll));
	}

	@Test
	public void testIsThreeOfAKind() {
		addPoints(4, 4, 4, 5, 6);
		assertEquals(7, aIsYathzeeOrKindOf.getCategory(aRoll));
	}

	@Test
	public void testIsThreeOfAKind2() {
		addPoints(1, 2, 2, 2, 6);
		assertEquals(7, aIsYathzeeOrKindOf.getCategory(aRoll));
	}

	@Test
	public void testIsThreerOfAKind3() {
		addPoints(1, 2, 4, 4, 4);
		assertEquals(7, aIsYathzeeOrKindOf.getCategory(aRoll));
	}

	@Test
	public void testIsThreerOfAKindWrong() {
		addPoints(1, 2, 2, 5, 6);
		assertEquals(0, aIsYathzeeOrKindOf.getCategory(aRoll));
	}
}
