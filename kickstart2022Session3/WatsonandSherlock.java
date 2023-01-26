package kickstart2022Session3;

import java.util.Scanner;

public class WatsonandSherlock {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {

		int cases = scanner.nextInt();
		String[] solutions = new String[cases];

		for (int i = 0; i < solutions.length; i++) {
			// String solution = "";

			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			int k = scanner.nextInt();

			int ans = 0;

			for (int j = 1; j <= n; j++) {
				for (int l = 1; l <= n; l++) {
					if (j==l)
						continue;
					int totalSprouts = squareNumber(j, a) + squareNumber(l, b);
					if (isDivisible(totalSprouts, k)) {
						ans++;
					}
				}
			}
			ans = shortenPair(ans);

			solutions[i] = "Case #" + (i + 1) + ": " + ans;
		}
		for (String solution : solutions) {
			System.out.println(solution);
		}
	}
	
	public static int squareNumber(int number,int square) {		
		int solution = 1;
		for (int i=0;i<square;i++) {
			solution*=number;
		}
		return solution;
	}

	public static boolean isDivisible(int totalsprouts, int k) {
		return totalsprouts % k == 0;
	}

	public static int shortenPair(int pair) {
		return pair % 1000000007;
	}

}
