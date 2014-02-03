package ch.metromec.yatzy;

import java.util.ArrayList;

public class Round {

	private ArrayList<Roll> RollsList = new ArrayList<>();
	private int roundIndex;

	public Round(int roundIndex) {
		this.roundIndex = roundIndex;
	}

	public void startRound() {
		throwDices();

	}

	private void throwDices() {
		for (int i = YatzyConstants.ZERO; i < YatzyConstants.CHANCE; i++) {
			Roll aRoll = new Roll();
			aRoll.FillRollWithRandomPoints();
			aRoll.orderRollPoints();
			addRoll(i, aRoll);
		}
	}

	public int getRoundIndex() {
		return roundIndex;
	}

	public void addRoll(int index, Roll roll) {
		if (index < YatzyConstants.ZERO || index > YatzyConstants.FULL_HOUSE) {
			throw new IndexOutOfBoundsException();
		} else if (roll == null) {
			throw new IllegalArgumentException();
		} else {
			RollsList.add(index, roll);
		}
	}

	public ArrayList<Roll> getRollsList() {
		return RollsList;
	}

	public Roll getRoll(int index) {
		if (index < YatzyConstants.ZERO || index > YatzyConstants.FULL_HOUSE)
			throw new IndexOutOfBoundsException();
		return RollsList.get(index);
	}

}
