package kickstart2022Session1RoundE;

import java.util.Scanner;

public class ColoringGame {
	
	//record = 14 min

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int cases = scanner.nextInt();
		String[] solutions = new String[cases];

		for (int i = 0; i < solutions.length; i++) {
			int nCells = scanner.nextInt();

			int ans = 0;
			
			for (int j = 0; j<nCells;j++) {
				if (j%3==0) {
					ans++;
				}
			}
			
			solutions[i] = Integer.toString(ans);

		}

		int i = 1;
		for (String solution : solutions) {
			System.out.println("Case #"+i+": "+solution);
			i++;
		}
	}

	public static boolean isWhite() {

		return false;
	}
}
