package ch.metromec.yatzy.gui;

import java.util.ArrayList;

import ch.metromec.yatzy.gui.contract.IGui;

public class PointsCalculatorGui implements IGui {

	@Override
	public ArrayList<String> getUserInput() {
		return null;
	}

	@Override
	public void printGivenOutput(String output) {
		System.out.println(output);

	}

	@Override
	public void printOutPut() {
		System.out.println(sYourThrowIs);

	}

	@Override
	public int getCategoryIndexFromUser() {
		System.out.println(sChooseCategory);
		return userInput.nextInt();
	}

	@Override
	public void printScore(int score) {
		System.out.println("Your score is: " + score + "!!");
	}

}
