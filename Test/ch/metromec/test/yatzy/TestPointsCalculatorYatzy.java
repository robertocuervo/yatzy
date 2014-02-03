package ch.metromec.test.yatzy;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import ch.metromec.test.mockgui.contract.IMockGui;
import ch.metromec.yatzy.PointsCalculatorYatzy;
import ch.metromec.yatzy.Roll;
import ch.metromec.yatzy.Round;

public class TestPointsCalculatorYatzy {
	private Round aRound;
	private PointsCalculatorYatzy aPointCalculator;
	private IMockGui mockGui = createMock(IMockGui.class);
	private ArrayList<Integer> scoresList;

	@Before
	public void setUp() throws Exception {
		aRound = new Round(1);
		// aPointCalculator = new PointsCalculatorYatzy(mockGui);
		scoresList = new ArrayList<>();
	}

	/**
	 * intern help method to check if the round scores are right
	 * @param scoresFromRound
	 * @param givenPoints
	 */
	private void checkRoundScores(ArrayList<Integer> scoresFromRound, int... givenPoints) {
		int temp = 0;
		for (int i = 0; i < scoresFromRound.size(); i++) {
			temp = scoresFromRound.get(i);
			assertEquals(givenPoints[i], temp);
		}
	}

	/**
	 * internal help method to fill the roll with given points, and set it in
	 * the round
	 * @param index
	 * @param pointList
	 */
	private void fillRoll(int index, int... pointList) {
		Roll temp = new Roll();
		for (int i = 0; i < pointList.length; i++) {
			temp.SetRollPoints(i, pointList[i]);
		}
		aRound.addRoll(index, temp);

	}

	/**
	 * fills the roll with given points, and calculates the roll scores with the
	 * given category (which mocks user's input)
	 * 
	 * @param index
	 * @param category
	 * @param pointList
	 */
	private void getRollScoresListWithCategory(int index, int category, int... pointList) {
		Roll temp = new Roll();

		for (int i = 0; i < pointList.length; i++) {
			temp.SetRollPoints(i, pointList[i]);
		}
		aRound.addRoll(index, temp);
		expect(mockGui.getCategoryIndexFromUser()).andReturn(category).anyTimes();
		replay(mockGui);
		scoresList = aPointCalculator.getScoreFromRolls(aRound);

	}

	/**
	 * set the values of <tt>mockGui</tt>
	 * @param returnsList
	 */
	private void addGuiReturns(int... returnsList) {
		for (int i : returnsList) {
			expect(mockGui.getCategoryIndexFromUser()).andReturn(i).once();
		}
	}

	@Test
	public void testAOnes() {
		getRollScoresListWithCategory(0, 1, 1, 1, 2, 3, 5);
		checkRoundScores(scoresList, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAOnes2() {
		getRollScoresListWithCategory(0, 1, 1, 1, 1, 3, 5);
		checkRoundScores(scoresList, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAOnes3() {
		getRollScoresListWithCategory(0, 1, 1, 1, 1, 1, 5);
		checkRoundScores(scoresList, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAOnesWrong() {
		getRollScoresListWithCategory(0, 1, 1, 1, 1, 1, 1);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testATwos() {
		getRollScoresListWithCategory(0, 2, 2, 2, 5, 5, 6);
		checkRoundScores(scoresList, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testATwos2() {
		getRollScoresListWithCategory(0, 2, 1, 1, 2, 2, 6);
		checkRoundScores(scoresList, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAYatzy() {
		getRollScoresListWithCategory(0, 9, 1, 1, 1, 1, 1);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAYatzyWrong() {
		getRollScoresListWithCategory(0, 9, 1, 1, 4, 4, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAYatzyWrong2() {
		getRollScoresListWithCategory(0, 9, 1, 1, 1, 1, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAFullHouse() {
		getRollScoresListWithCategory(0, 12, 3, 3, 3, 4, 4);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAFullHouse2() {
		getRollScoresListWithCategory(0, 12, 2, 2, 3, 3, 3);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAFullHouseWrong() {
		getRollScoresListWithCategory(0, 12, 3, 3, 3, 4, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testALargeStraight() {
		getRollScoresListWithCategory(0, 11, 2, 3, 4, 5, 6);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testALargeStraight2() {
		getRollScoresListWithCategory(0, 11, 1, 2, 3, 4, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 40, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testALargeStraightWrong() {
		getRollScoresListWithCategory(0, 11, 1, 2, 3, 3, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testASmallStraight() {
		getRollScoresListWithCategory(0, 10, 1, 2, 3, 4, 6);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testASmallStraight2() {
		getRollScoresListWithCategory(0, 10, 2, 3, 4, 5, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testASmallStraightWrong() {
		getRollScoresListWithCategory(0, 10, 2, 3, 4, 5, 6);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAThreeOfAKind() {
		getRollScoresListWithCategory(0, 7, 3, 3, 3, 5, 6);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAThreeOfAKind2() {
		getRollScoresListWithCategory(0, 7, 3, 4, 5, 5, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAThreeOfAKind3() {
		getRollScoresListWithCategory(0, 7, 3, 5, 5, 5, 6);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAFourOfAKind() {
		getRollScoresListWithCategory(0, 8, 3, 5, 5, 5, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAFourOfAKind2() {
		getRollScoresListWithCategory(0, 8, 3, 3, 3, 3, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAFourOfAKindWrong() {
		getRollScoresListWithCategory(0, 8, 3, 3, 3, 3, 3);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		verify(mockGui);
	}

	@Test
	public void testAChance() {
		getRollScoresListWithCategory(0, 13, 3, 3, 3, 3, 5);
		checkRoundScores(scoresList, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0);
		verify(mockGui);
	}

	@Test
	public void testRound() {
		fillRoll(0, 1, 1, 2, 3, 5);
		fillRoll(1, 2, 2, 3, 5, 6);
		fillRoll(2, 1, 3, 3, 4, 5);
		fillRoll(3, 1, 2, 4, 4, 5);
		fillRoll(4, 1, 1, 2, 5, 5);
		fillRoll(5, 1, 1, 2, 6, 6);
		fillRoll(6, 1, 1, 1, 1, 1);
		fillRoll(7, 2, 2, 2, 3, 4);
		fillRoll(8, 1, 1, 1, 1, 5);
		fillRoll(9, 1, 1, 1, 2, 2);
		fillRoll(10, 1, 2, 3, 4, 5);
		fillRoll(11, 2, 3, 4, 5, 5);
		fillRoll(12, 1, 2, 3, 5, 6);
		addGuiReturns(1, 2, 3, 4, 5, 6, 9, 7, 8, 12, 11, 10, 13);
		replay(mockGui);
		scoresList = aPointCalculator.getScoreFromRolls(aRound);
		checkRoundScores(scoresList, 2, 4, 6, 8, 10, 12, 13, 9, 50, 30, 40, 25, 17, 0);
		assertEquals(226, aPointCalculator.getTotalRoundScore());
		verify(mockGui);
	}

	@Test
	public void testRoundWithUpperBonus() {
		fillRoll(0, 1, 1, 1, 2, 5);
		fillRoll(1, 2, 2, 2, 5, 6);
		fillRoll(2, 1, 3, 3, 3, 5);
		fillRoll(3, 1, 2, 4, 4, 4);
		fillRoll(4, 1, 1, 5, 5, 5);
		fillRoll(5, 1, 1, 6, 6, 6);
		fillRoll(6, 1, 1, 1, 1, 1);
		fillRoll(7, 2, 2, 2, 3, 4);
		fillRoll(8, 1, 1, 1, 1, 5);
		fillRoll(9, 1, 1, 1, 2, 2);
		fillRoll(10, 1, 2, 3, 4, 5);
		fillRoll(11, 2, 3, 4, 5, 5);
		fillRoll(12, 1, 2, 3, 5, 6);
		addGuiReturns(1, 2, 3, 4, 5, 6, 9, 7, 8, 12, 11, 10, 13);
		replay(mockGui);
		scoresList = aPointCalculator.getScoreFromRolls(aRound);
		checkRoundScores(scoresList, 3, 6, 9, 12, 15, 18, 13, 9, 50, 30, 40, 25, 17, 35);
		assertEquals(282, aPointCalculator.getTotalRoundScore());
		verify(mockGui);
	}
}
