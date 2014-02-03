package ch.metromec.yatzy.internGetCategory;

import ch.metromec.yatzy.internGetCategory.contract.IInternGetCategory;

public class CategoryFactory {

	public static IInternGetCategory getCategory(String categoryName) {
		if (!categoryName.isEmpty()) {
			switch (categoryName) {
			case "Ones":
			case "Twos":
			case "Threes":
			case "Fours":
			case "Fives":
			case "Sixes":
				return new IsOneToSixes();
			case "ThreeOfAKind":
			case "FourOfAKind":
			case "Yahtzee":
				return new IsYathzeeOrKindOf();
			case "SmallStraight":
			case "LargeStraight":
				return new IsSmallOrLargeStraight();
			case "FullHouse":
				return new IsFullHouse();
			case "Chance":
				return new IsChance();
			default:
				return null;
			}
		}
		return null;
	}

}
