package bowling;

/**
 * Scorer keeps track of the individual score of every ball, as well as provides
 * scores to the Game on a per frame basis.
 * 
 * @author Max Fowler
 *
 */
public class Scorer {

	private int scores[];
	private int curBall;
	private boolean strikeFrames[];
	private boolean spareFrames[];
	public static final int MAX_ROLL_SPOTS = 22;
	public static final int MAX_FRAMES = 10;
	public static final int MAX_ROLL = 10;
	public static final int FIRST_BALL = 0;
	public static final int SECOND_BALL = 1;

	/**
	 * The constructor initializes an array to hold scores, as well as an array
	 * to hold whether or not a given frame is a strike or a spare.
	 * 
	 * The scores are set up slot wise, allowing for 10 frames * 2 shots = 20
	 * spaces + 2 for bonus shots. The other arrays are set up frame wise.
	 */
	public Scorer() {
		scores = new int[MAX_ROLL_SPOTS];
		curBall = 0;

		for (int i = 0; i < MAX_ROLL_SPOTS; i++) {
			scores[i] = 0;

		}

		strikeFrames = new boolean[MAX_FRAMES];
		spareFrames = new boolean[MAX_FRAMES];
		for (int i = 0; i < MAX_FRAMES; i++) {
			strikeFrames[i] = false;
			spareFrames[i] = false;
		}
	}

	/**
	 * Returns a score from a requested position. To ensure the scores won't
	 * include stale data or data that is counted multiple times, the scorers
	 * are dynamically calculated.
	 * 
	 * The scoring code is a little bit ugly, but it works out. There is some
	 * repetition, but the repetition was maintained to make the if statements
	 * more legible and for the sake of handling the representation for strikes
	 * this code uses (10, followed by a 0 for rolls n and n+1).
	 * 
	 * @param position
	 * @return
	 */
	public int returnScore(int frame) {
		int ballPointer1 = frame * 2;
		int ballPointer2 = frame * 2 + 1;
		int score = scores[ballPointer1] + scores[ballPointer2];
		if (strikeFrames[frame]) {
			if (frame < MAX_FRAMES - 2 && strikeFrames[frame + 1]
					&& strikeFrames[frame + 2]) {
				return scores[ballPointer1] + scores[ballPointer1 + 2]
						+ scores[ballPointer1 + 4];
			} else if (frame < MAX_FRAMES - 1 && strikeFrames[frame + 1]) {
				return scores[ballPointer1] + scores[ballPointer1 + 2]
						+ scores[ballPointer1 + 3];
			} else {
				if (frame == MAX_FRAMES - 1) {
					score = scores[ballPointer1] + scores[ballPointer2 + 1];
					if (scores[ballPointer2 + 1] == 10) {
						return score + 2 * scores[ballPointer2 + 2];
					} else {
						return score + scores[ballPointer2 + 2];
					}
				}
				return scores[ballPointer1] + scores[ballPointer1 + 2]
						+ scores[ballPointer1 + 3];
			}
		} else if (spareFrames[frame]) {
			return score + scores[ballPointer2 + 1];
		} else {
			return score;
		}
	}

	public void add(int pins, int ball, int frame) {
		scores[curBall] += pins;
		if (pins == MAX_ROLL && ball == FIRST_BALL) {
			strikeFrames[frame] = true;
			curBall++;
		} else if (ball == SECOND_BALL) {
			if (scores[curBall] + scores[curBall - 1] == MAX_ROLL) {
				spareFrames[frame] = true;
			}
		}
		curBall++;
	}

}
