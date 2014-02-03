package ch.metromec.test.yatzy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ch.metromec.yatzy.CategoryGetter;
import ch.metromec.yatzy.Roll;

public class TestCategoryGetter {
	Roll aRoll;
	ArrayList<Integer> categories;

	@Before
	public void setUp() {
		aRoll = new Roll();
		categories = new ArrayList<>();
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

	/**
	 * Help method to compare the given categories list to the from
	 * Category.getCategories returned categories list
	 * 
	 * @param aList the returned list
	 * @param categoriesList the list we create for testing purpose
	 */

	private void checkCategories(ArrayList<Integer> aList, int... categoriesList) {
		for (int i = 0; i < aList.size(); i++) {
			int aCategory1 = categoriesList[i];
			int aCategory2 = aList.get(i);
			assertEquals(aCategory1, aCategory2);
		}
	}

	/**
	 * Tests to which possibles categories can belong the given roll
	 **/
	@Test
	public void testIsAOnes() {
		addPoints(1, 1, 2, 3, 5);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 1, 13);
	}

	@Test
	public void testGetCategoriesYathzee() {
		// this given roll belongs to categories: fives,
		// Yathzee, Chance
		addPoints(5, 5, 5, 5, 5);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 5, 9, 13);
	}

	@Test
	public void testGetCategoriesOnesAndFullHouse() {
		// this given roll belongs to categories: ones, fives,
		// threeOfAKind,FullHouse, Chance
		addPoints(1, 1, 5, 5, 5);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 1, 7, 12, 13);
	}

	@Test
	public void testGetCategoriesSixes() {
		// this given roll belongs to categories:
		// Sixes and Chance
		addPoints(1, 2, 3, 6, 6);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 6, 13);
	}

	@Test
	public void testGetCategoriesThrees() {
		// this given roll belongs to categories:
		// Threes and Chance
		addPoints(1, 2, 3, 3, 6);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 3, 13);
	}

	@Test
	public void testGetCategoriesSMallStraight() {
		// this given roll belongs to categories:
		// Small Straight and Chance
		addPoints(1, 2, 3, 4, 6);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 10, 13);
	}

	@Test
	public void testGetCategoriesLargeStraight() {
		// this given roll belongs to categories:
		// Large Straight and Chance
		addPoints(1, 2, 3, 4, 5);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 11, 13);
	}

	@Test
	public void testGetCategoriesLargeStraight2() {
		// this given roll belongs to categories:
		// Large Straight and Chance
		addPoints(2, 3, 4, 5, 6);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 11, 13);
	}

	@Test
	public void testGetCategoriesTwos() {
		// this given roll belongs to categories:
		// Two and Chance
		addPoints(2, 2, 3, 3, 5);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 2, 13);
	}

	@Test
	public void testGetCategoriesThreeOfAKind() {
		// this given roll belongs to categories:
		// Fours, Three of a kind and Chance
		addPoints(2, 3, 4, 4, 4);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 4, 7, 13);
	}

	@Test
	public void testGetCategoriesThreeOfAKind2() {
		// this given roll belongs to categories:
		// Twos, ThreeOfAKind and Chance
		addPoints(2, 2, 2, 4, 5);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 2, 7, 13);
	}

	@Test
	public void testGetCategoriesFourOfAKind() {
		// this given roll belongs to categories:
		// Fours, FourOfAKind and Chance
		addPoints(2, 4, 4, 4, 4);
		categories = CategoryGetter.getCategories(aRoll);
		checkCategories(categories, 4, 8, 13);
	}
}
