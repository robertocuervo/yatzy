package ch.metromec.yatzy.gui.contract;

import java.util.ArrayList;
import java.util.Scanner;

public interface IGui {
	Scanner userInput = new Scanner(System.in);
	String sYourThrowIs = "Your throw is: \n";
	String sChooseCategory = "Please, choose your category by entering the corresponding number: ";

	public ArrayList<String> getUserInput();

	public int getCategoryIndexFromUser();

	public void printGivenOutput(String output);

	public void printOutPut();

	public void printScore(int score);
}
