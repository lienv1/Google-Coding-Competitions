package kickstart2022Session3;

import java.util.Scanner;

public class WiggleWalk {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int cases = scanner.nextInt();

		int[][] solutions = new int[cases][2];

		for (int i = 0; i < cases; i++) {
			// useless
			int nInstructions = scanner.nextInt();
			int rRows = scanner.nextInt();
			int cColumns = scanner.nextInt();
			int startPositionR = scanner.nextInt();
			int startPositionC = scanner.nextInt();
			boolean seen[][] = new boolean[rRows+1][cColumns+1];
			seen[startPositionR][startPositionC] = true;
			String instructionInput = scanner.next();

			String[] instructions = instructionInput.split("");

			for (String instruction : instructions) {
				switch (instruction) {
				case "N":
					startPositionR--;
					while (hasSeen(seen, startPositionR, startPositionC)) {
						startPositionR--;
					}
					seen[startPositionR][startPositionC] = true;
					break;
				case "S":
					startPositionR++;

					while (hasSeen(seen, startPositionR, startPositionC)) {
						startPositionR++;
					}
					seen[startPositionR][startPositionC] = true;
					break;
				case "W":
					startPositionC--;

					while (hasSeen(seen, startPositionR, startPositionC)) {
						startPositionC--;
					}
					seen[startPositionR][startPositionC] = true;
					break;
				default:
					startPositionC++;

					while (hasSeen(seen, startPositionR, startPositionC)) {
						startPositionC++;
					}
					seen[startPositionR][startPositionC] = true;
					break;
				}

			}
			solutions[i][0] = startPositionR;
			solutions[i][1] = startPositionC;
		}

		for (int[] solution : solutions) {
			System.out.println(solution[0] + " " + solution[1]);
		}

	}

	private static boolean hasSeen(boolean[][] seen, int rRow, int cColumn) {
		if (seen[rRow][cColumn] == true) {

			return true;
		}
		return false;
	}
}
