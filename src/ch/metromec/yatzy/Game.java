package ch.metromec.yatzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ch.metromec.yatzy.gui.GameGui;
import ch.metromec.yatzy.gui.contract.IGui;

/**
 * @author RCu
 * 
 */
public class Game {
	private Map<Player, Round> playersAndItsRounds = new HashMap<Player, Round>();
	private int totalGameScore;

	public void startGame() {
		getPlayersAndRounds();
		getTotalGameScore();
	}

	private void getPlayersAndRounds() {
		ArrayList<String> playersNames = new ArrayList<>();
		playersNames = getPlayersNames();
		if (playersNames != null)
			for (int i = 0; i < playersNames.size(); i++) {
				String aName = playersNames.get(i);
				Round aRound = new Round(i);
				aRound.startRound();
				playersAndItsRounds.put(new Player(aName), aRound);
			}
	}

	private ArrayList<String> getPlayersNames() {
		IGui gameGui = new GameGui();
		return gameGui.getUserInput();
	}

	private void getTotalGameScore() {
		Round aRound;
		Player aPlayer;
		PointsCalculatorYatzy pointCalculator = new PointsCalculatorYatzy();
		IGui gameGui = new GameGui();
		for (Map.Entry<Player, Round> entry : playersAndItsRounds.entrySet()) {
			aRound = entry.getValue();
			aPlayer = entry.getKey();
			pointCalculator.getScoreFromRolls(aRound);
			totalGameScore = pointCalculator.getTotalRoundScore();
			gameGui.printGivenOutput(aPlayer.getName());
			gameGui.printScore(totalGameScore);
		}
	}
}
