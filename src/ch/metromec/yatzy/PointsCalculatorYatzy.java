package ch.metromec.yatzy;

import java.util.ArrayList;
import ch.metromec.calculatePoint.CalculatePointsFactory;
import ch.metromec.calculatePoints.contract.ICalculatePoints;
//import ch.metromec.test.mockgui.contract.IMockGui;
import ch.metromec.yatzy.gui.PointsCalculatorGui;
import ch.metromec.yatzy.gui.contract.IGui;

/**
 * @author RCu
 * 
 */
public class PointsCalculatorYatzy {
	private CategoriesComparator occupiedCategoriesList = new CategoriesComparator();
	private ArrayList<Integer> scores = new ArrayList<>();
	private IGui categoriesGui = new PointsCalculatorGui();

	// private IMockGui aPointsCalculatorMockGui;

	// constructor for mock testing
	// public PointsCalculatorYatzy(IMockGui aMockGui) {
	// this.aPointsCalculatorMockGui = aMockGui;
	// }

	public PointsCalculatorYatzy() {

	}

	public int getTotalRoundScore() {
		int totalRoundScore = 0;
		for (int aSingleRollScore : scores) {
			totalRoundScore += aSingleRollScore;
		}
		return totalRoundScore;
	}

	public ArrayList<Integer> getScoreFromRolls(Round aRound) {
		ArrayList<Roll> rollsList = aRound.getRollsList();
		occupiedCategoriesList.intializeList();
		initializeScoresList();
		int[] rollScore;
		if (aRound != null)
			for (Roll aRoll : rollsList) {
				rollScore = calculateScoreWithUserInput(aRoll);
				categoriesGui.printScore(rollScore[1]);
				scores.set((rollScore[0] - 1), rollScore[1]);
				categoriesGui.printGivenOutput("Your score until now is: " + getTotalRoundScore()
						+ "\n");
				checkIfUpperBonus();
			}
		return scores;
	}

	private void initializeScoresList() {
		for (int i = 0; i < 14; i++) {
			scores.add(0);
		}
	}

	private int[] calculateScoreWithUserInput(Roll aRoll) {
		int[] rollScore = new int[2];
		ICalculatePoints aCalculatePoints;
		if (aRoll != null)
			showFreeRollCategories(aRoll.printRoll());
		rollScore[0] = getCategoryIndexFromUser();
		categoriesGui.printGivenOutput("You choosed the " + rollScore[0] + " category");
		aCalculatePoints = CalculatePointsFactory.getCategoryForPointsCalculating(rollScore[0]);
		if (aCalculatePoints != null)
			rollScore[1] = aCalculatePoints.getRollPointsWithCategoryIndex(aRoll, rollScore[0]);
		return rollScore;
	}

	private int getCategoryIndexFromUser() {
		int categoryIndex = 0;
		categoryIndex = categoriesGui.getCategoryIndexFromUser();
		// categoryIndex = aPointsCalculatorMockGui.getCategoryIndexFromUser();
		occupiedCategoriesList.markAsOccupied(categoryIndex - 1);
		return categoryIndex;
	}

	private void checkIfUpperBonus() {
		int sum = 0;
		boolean messageShowed = true;
		for (int i = 0; i < 6; i++) {
			if (!occupiedCategoriesList.isCategoryFree(i))
				sum += scores.get(i);
		}
		if (sum >= YatzyConstants.UPPERVALUE) {
			scores.set(13, YatzyConstants.UPPERBONUS);
			if (messageShowed) {
				categoriesGui.printGivenOutput("You got the 35 Points upper bonus!!\n");
				messageShowed = false;
			}
		}
	}

	private void showFreeRollCategories(String rollPoints) {
		if (!rollPoints.isEmpty()) {
			categoriesGui.printOutPut();
			categoriesGui.printGivenOutput(rollPoints);
			categoriesGui.printGivenOutput("Your open options are: ");
			for (int i = 0; i <= 12; i++) {
				if (occupiedCategoriesList.isCategoryFree(i)) {
					categoriesGui.printGivenOutput((i + 1) + " - "
							+ YatzyConstants.categoriesNames.get(i));
				}
			}
		}
	}
}
