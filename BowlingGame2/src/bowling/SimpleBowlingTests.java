package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * SimpleBowlingTests used http://www.bowlinggenius.com/ to ensure the bowling
 * arithmetic was correct. The programmer, Max, cannot add bowling scores to
 * save his life :D (outside of the simple ones).
 * 
 * @author Max Fowler
 *
 */
public class SimpleBowlingTests {

	/**
	 * This additive test is one of the additive tests from the homework
	 * documentation.
	 */
	@Test
	public void homeworkDocAddTest() {
		Game g = new Game();
		g.add(4);
		g.add(5);
		assertEquals(g.score(), 9);
	}

	/**
	 * This additive test is one of the additive tests from the homework.
	 */
	@Test
	public void homeworkDocAddTest2() {
		Game g = new Game();
		g.add(3);
		g.add(7);
		g.add(3);
		g.add(2);
		assertEquals(g.score(), 18);
	}

	/**
	 * This code makes sure that incorrect input is ignored and the score
	 * remains 0 despite multiple attempts to add wrong scores.
	 */
	@Test
	public void wrongInputTest() {
		Game g = new Game();
		g.add(-4);
		g.add(-5);
		g.add(14);
		g.add(16);
		g.add(25);
		
		assertEquals(g.score(), 0);
	}

	/**
	 * This test case represents an organic game with made up rolls.
	 */
	@Test
	public void organicGame() {
		Game g = new Game();
		g.add(3);
		g.add(2);
		g.add(4);
		g.add(3);
		g.add(6);
		g.add(4);
		g.add(8);
		g.add(1);
		g.add(10);
		g.add(3);
		g.add(5);
		g.add(6);
		g.add(2);
		g.add(6);
		g.add(2);
		g.add(3);
		g.add(2);
		g.add(2);
		g.add(1);

		assertEquals(g.score(), 89);
	}

	/**
	 * simpleAdditiveTest checks to see if 9 + 4 is 13.
	 */
	@Test
	public void simpleAdditiveTest() {
		Game g = new Game();
		g.add(9);
		g.add(4);
		assertEquals(g.score(), 13);
	}

	/**
	 * simpleAddTestTwo tests to see if scoring 9 in all 10 frames results in
	 * 90.
	 */
	@Test
	public void simpleAddTestTwo() {
		Game g = new Game();
		for (int i = 0; i < Scorer.MAX_FRAMES; i++) {
			g.add(5);
			g.add(4);
		}
		assertEquals(g.score(), 90);
	}

	/**
	 * simpleSpareTest tests to see if a frame 1 with score [9, 1] and a second
	 * frame with just a 3 correctly add (9+1+3)+3 to get 16.
	 */
	@Test
	public void simpleSpareTest() {
		Game g = new Game();
		g.add(9);
		g.add(1);
		g.add(3);
		assertEquals(g.score(), 16);
	}

	/**
	 * simpleStrikeTest tests to make sure that a game with a strike then a
	 * non-strike succesfully adds. In this case, it is (10 + 3 + 4) + 3 + 4 to
	 * get 24.
	 */
	@Test
	public void simpleStrikeTest() {
		Game g = new Game();
		g.add(10);
		g.add(3);
		g.add(4);
		assertEquals(g.score(), 24);
	}

	/**
	 * allStrikeTest ensures that throwing all strikes results in a score of
	 * 300.
	 */
	@Test
	public void allStrikeTest() {
		Game g = new Game();
		for (int i = 0; i < Scorer.MAX_FRAMES; i++) {
			g.add(10);
		}
		// Throw two extra balls, because strike in the last spot!
		g.add(10);
		g.add(10);
		assertEquals(g.score(), 300);
	}

	/**
	 * finalSpareTest checks to see if having a score of 2 until the last frame,
	 * where the player gets a spare and another 2, adds up to 30 successfully.
	 */
	@Test
	public void finalSpareTest() {
		Game g = new Game();
		for (int i = 0; i < Scorer.MAX_FRAMES - 1; i++) {
			g.add(1);
			g.add(1);
		}
		g.add(5);
		g.add(5);
		// Extra ball -> spare
		g.add(2);
		assertEquals(g.score(), 30);
	}

	/**
	 * allSparesTest checks to see if getting all spares, and then a final 5,
	 * results in the expected score of 150.
	 */
	@Test
	public void allSparesTest() {
		Game g = new Game();
		for (int i = 0; i < Scorer.MAX_FRAMES; i++) {
			g.add(5);
			g.add(5);
		}
		// Extra ball
		g.add(5);
		assertEquals(g.score(), 150);
	}

}
