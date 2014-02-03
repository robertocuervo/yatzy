package ch.metromec.yatzy.gui;

import java.util.ArrayList;

import ch.metromec.yatzy.gui.contract.IGui;

public class GameGui implements IGui {
	// TODO validate user input
	@Override
	public ArrayList<String> getUserInput() {
		ArrayList<String> inputs = new ArrayList<>();
		printOutPut();
		inputs.add(userInput.nextLine());
		return inputs;
	}

	@Override
	public void printGivenOutput(String output) {
		System.out.println("Player " + output + ":");
	}

	@Override
	public void printOutPut() {
		System.out.println("Enter a player name, please: ");

	}

	@Override
	public int getCategoryIndexFromUser() {
		return 0;
	}

	@Override
	public void printScore(int score) {
		System.out.println("Your total score is: " + score + "\n");

	}

}
