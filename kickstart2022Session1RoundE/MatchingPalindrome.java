package kickstart2022Session1RoundE;

import java.util.Scanner;

public class MatchingPalindrome {

	// 2 attempt record = 30 min

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {
		int cases = scanner.nextInt();
		String[] solutions = new String[cases];

		for (int i = 0; i < solutions.length; i++) {
			String solution = "";
			int length = scanner.nextInt();

			String palindrome = scanner.next();
			solutions[i] = repeatingStr(palindrome);
		}

		int i = 0;
		for (String solution : solutions) {
			System.out.println("Case #" + (i + 1) + ": " + solution);
			i++;
		}

	}

	public static String repeatingStr(String str) {
		String sol = str;
		for (int i = 1; i < str.length(); i++) {
			String checkForRepeat = str.substring(0, i);
			if (isAlwaysRepeating(checkForRepeat, str)) {
				return checkForRepeat;
			}
		}

		return sol;
	}

	public static boolean isAlwaysRepeating(String repeat, String fullword) {
		String str = "";
		String last = fullword.substring(fullword.length() - repeat.length(), fullword.length());
		for (int i = 0; i <= fullword.length() - repeat.length(); i += repeat.length()) {
			String subfullword = fullword.substring(i, i + repeat.length());
			if (!subfullword.contentEquals(repeat)) {
				return false;
			}
			if (!last.contentEquals(repeat)) {
				return false;
			}
		}
		return true;
	}

}
