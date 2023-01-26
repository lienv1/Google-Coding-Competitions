package kickstart2022Session3;

import java.util.Scanner;

public class RecordBreaker {

	public static void main(String[] args) {
		solve();
	}

	public static void solve() {

		Scanner scanner = new Scanner(System.in);
		int tCases = scanner.nextInt();

		int solutions[] = new int[tCases];

		for (int i = 0; i < solutions.length; i++) {
			int nDays = scanner.nextInt();
			int nVisitors[] = new int[nDays];
			int recordBreaking = 0;

			for (int j = 0; j < nVisitors.length; j++) {
				nVisitors[j] = scanner.nextInt();
			}

			for (int j = 0; j < nVisitors.length; j++) {
				if (isRecordBreaky(nVisitors, nVisitors[j], j)) {
					recordBreaking++;
				}
			}
			solutions[i] = recordBreaking;
		}

		for (int solution : solutions) {
			System.out.println(solution);
		}

	}

	public static boolean isRecordBreaky(int totalDays[], int visitors, int currentDay) {
		boolean condition1 = false;
		boolean condition2 = false;

		int lastDay = totalDays.length;

		int[] previousDays = getPreviousDays(totalDays, currentDay);

		if (currentDay == 0 || currentVisitorIsLargerThanPrevious(previousDays, visitors)) {
			condition1 = true;
		} 
		if (currentDay == (lastDay - 1)
				|| currentVisitorIsLargerThanFollowingDay(totalDays[currentDay + 1], visitors)) {
			condition2 = true;
		}
		return condition1 && condition2;
	}

	public static boolean currentVisitorIsLargerThanPrevious(int[] previousDays, int currentVisitor) {
		for (int i = 0; i < previousDays.length; i++) {
			if (currentVisitor <= previousDays[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean currentVisitorIsLargerThanFollowingDay(int followingDay, int currentVisitor) {
		return currentVisitor > followingDay;
	}

	public static int[] getPreviousDays(int days[], int currentDay) {
		int previous[] = new int[currentDay];
		for (int i = 0; i < previous.length; i++) {
			previous[i] = days[i];
		}
		return previous;
	}

}
