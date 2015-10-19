package bowling;

/**
 * Game handles the adding of new throws and gets the current game score by
 * adding the scores from the Scorer object, sc.
 * 
 * @author Max Fowler
 *
 */
public class Game {

	private Scorer sc;
	private int currentFrame;
	private int throwCount;

	/**
	 * Initialize a new game with an empty Scorer, throwCount of 0, and the
	 * starting frame of 0.
	 */
	public Game() {
		sc = new Scorer();
		currentFrame = 0;
		throwCount = 0;
	}

	/**
	 * This method sums, then returns the scores from the Scorer object
	 * 
	 * @return
	 */
	public int score() {
		int score = 0;
		for (int frame = 0; frame <= currentFrame; frame++) {

			score += sc.returnScore(frame);
		}
		return score;
	}

	/**
	 * According to the description, both the Game and the Scorer must handle
	 * pins. Game handles keeping an updated frame and throw count, to ensure
	 * the scorers are placed in their proper array positions.
	 * 
	 * Strikes are represented fair as '10' '0' in the frame array positions.
	 * 
	 * @param pins
	 */
	public void add(int pins) {
		
		if(pins > 10 || pins < 0){
			System.out.println("Pins must be between 0 and 10!");
			return;
		}

		sc.add(pins, throwCount, currentFrame);
		if (pins == Scorer.MAX_ROLL && currentFrame < (Scorer.MAX_FRAMES - 1)) {
			throwCount += 2;
		} else {
			throwCount++;
		}

		if (currentFrame < Scorer.MAX_FRAMES - 1 && throwCount % 2 == 0) {
			currentFrame++;
			throwCount = 0;
		}

	}

}
