package kickstart2022Session3;

import java.util.Scanner;

public class GBusCount {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// The first line of the input gives the number of test cases, T.
		int cases = scanner.nextInt();
		
		String [] solutions = new String[cases];
		
		for (int i = 0; i < cases; i++) {
			// The first line contains one integer N: the number of GBuses.
			int nBusses = scanner.nextInt();
			// The second line contains 2N integers representing the ranges of cities that
			// the buses serve, in the form A1 B1 A2 B2 A3 B3
			int cities[] = new int[nBusses * 2];
			for (int j = 0; j < cities.length; j++) {
				cities[j] = scanner.nextInt();
				cities[j + 1] = scanner.nextInt();
				j++;
			}
			// The third line contains one integer P: the number of cities we are interested
			// in
			int pInterestedCities = scanner.nextInt();
			// Finally, there are P more lines; the i-th of these contains the number Ci of
			// a city we are interested in.
			int interestedCities[] = new int[pInterestedCities];
			for (int j = 0; j < pInterestedCities; j++) {
				interestedCities[j] = scanner.nextInt();
			}
			
			String answ = "";
			for (int j = 0; j < pInterestedCities; j++) {
				int counter = 0;
				for (int k = 0; k < cities.length; k += 2) {
					String ans = "";
					if (doesServe(cities[k], cities[k + 1], interestedCities[j])) {
						counter++;
					}
				}
				answ += counter + " ";
			}
			solutions[i] = "Case #" + (i + 1) + ": " + answ;
		}
		
		for (String solution:solutions) {
			System.out.println(solution);
		}

	}

	public static boolean doesServe(int start, int dest, int interested) {
		// System.out.println("Check if interested " + interested + " is bigger than
		// start " + start + " and smaller than dest " +dest);
		return interested >= start && interested <= dest;
	}

}
