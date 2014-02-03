package ch.metromec.yatzy;

import java.util.ArrayList;
import java.util.Random;

/**
 * A Roll represents a single throw of five dices. The dices scores are from 1
 * to 6
 * 
 * @author RCu
 */
public class Roll {

	private ArrayList<Integer> Rollpoints = new ArrayList<>();

	public void SetRollPoints(int index, int pointsToAdd) {
		if (index < YatzyConstants.ZERO || index > YatzyConstants.FOURS) {
			throw new IndexOutOfBoundsException();
		} else if (pointsToAdd < YatzyConstants.ONES || pointsToAdd > YatzyConstants.SIXES) {
			throw new IllegalArgumentException();
		} else {
			this.Rollpoints.add(index, pointsToAdd);
		}
	}

	public int GetRollPoints(int index) {
		if (index < YatzyConstants.ZERO || index > YatzyConstants.FOURS)
			throw new IndexOutOfBoundsException();
		return this.Rollpoints.get(index);
	}

	public void FillRollWithRandomPoints() {
		Random random = new Random();
		for (int i = YatzyConstants.ZERO; i <= YatzyConstants.FOURS; i++) {
			int points = random.nextInt(YatzyConstants.SIXES) + 1;
			SetRollPoints(i, points);
		}
	}

	/**
	 * Calculates the total roll points. Useful method to get the Chance points
	 */
	public int SumAllRollPoints() {
		int rollScore = YatzyConstants.ZERO;
		for (int points : Rollpoints) {
			rollScore += points;
		}
		return rollScore;
	}

	/**
	 * Order the roll values from smaller to the highest. Help method in order
	 * to better finding of Straight and Full House, etc
	 */
	public void orderRollPoints() {

		for (int i = YatzyConstants.ZERO; i < Rollpoints.size(); i++) {
			for (int j = YatzyConstants.ZERO; j < Rollpoints.size(); j++) {
				// swap if right value is greater than the left
				if (Rollpoints.get(i) < Rollpoints.get(j)) {
					int temp = Rollpoints.get(i);
					Rollpoints.set(i, Rollpoints.get(j));
					Rollpoints.set(j, temp);
				}

			}
		}
	}

	public String printRoll() {
		return Rollpoints.toString();
	}
}
