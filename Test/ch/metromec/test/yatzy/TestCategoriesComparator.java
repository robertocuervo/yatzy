package ch.metromec.test.yatzy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.CategoriesComparator;

public class TestCategoriesComparator {
	CategoriesComparator aComparator;

	@Before
	public void setUp() {
		aComparator = new CategoriesComparator();
		aComparator.intializeList();

	}

	@Test
	public void testConstructor() {
		assertTrue(aComparator.isCategoryFree(0));
	}

	@Test
	public void testSetACategory() {
		aComparator.markAsOccupied(3);
		assertFalse(aComparator.isCategoryFree(3));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void tesGetACategoryWrongIndexLowBounding() {
		aComparator.isCategoryFree(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetACategoryWrongIndexUpperBounding() {
		aComparator.isCategoryFree(13);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetACategoryWrongIndex() {
		aComparator.markAsOccupied(13);
	}

}
