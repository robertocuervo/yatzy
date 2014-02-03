package ch.metromec.yatzy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains all the needed constants and the equivalence between category names
 * and category values. For example, the category <tt>Ones</tt> has the
 * <tt>1</tt> value, or the <tt>Full House</tt> category has the <tt>12</tt>
 * value.
 * @author RCu
 * 
 */
public final class YatzyConstants {
	public static final int ZERO = 0;
	// CATEGORIES
	public static final int ONES = 1;
	public static final int TWOS = 2;
	public static final int THREES = 3;
	public static final int FOURS = 4;
	public static final int FIVES = 5;
	public static final int SIXES = 6;
	public static final int THREEE_OF_A_KIND = 7;
	public static final int FOUR_OF_A_KIND = 8;
	public static final int YATHZEE = 9;
	public static final int SMALL_STRAIGHT = 10;
	public static final int LARGE_STRAIGHT = 11;
	public static final int FULL_HOUSE = 12;
	public static final int CHANCE = 13;
	public static final int FULL_HOUSE_POINTS = 25;
	public static final int LARGE_STRAIGHT_POINTS = 40;
	public static final int SMALL_STRAIGHT_POINTS = 30;
	public static final int YATHZEE_POINTS = 50;
	public static final int UPPERBONUS = 35;
	public static final int UPPERVALUE = 63;
	public static final List<String> categoriesNames;
	static {
		ArrayList<String> aList = new ArrayList<>();
		aList.add("Ones");
		aList.add("Twos");
		aList.add("Threes");
		aList.add("Fours");
		aList.add("Fives");
		aList.add("Sixes");
		aList.add("ThreeOfAKind");
		aList.add("FourOfAKind");
		aList.add("Yahtzee");
		aList.add("SmallStraight");
		aList.add("LargeStraight");
		aList.add("FullHouse");
		aList.add("Chance");
		categoriesNames = Collections.unmodifiableList(aList);
	}

	private YatzyConstants() {

	}

}
