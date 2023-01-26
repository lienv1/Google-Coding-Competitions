package kickstart2022Session1RoundE;

import java.util.Scanner;

public class StudentsAndMentors {
	
	//record = 37 min
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		solve();
	}
	

	public static void solve() {

		int cases = scanner.nextInt();
		String[] solutions = new String[cases];

		for (int i = 0; i < solutions.length; i++) {
			String solution = "";
			int nStudents = scanner.nextInt();
			
			int studentsGrade [] = new int [nStudents];
			
			for (int j = 0; j<nStudents; j++) {
				studentsGrade[j] = scanner.nextInt();
			}
			
			String ans = "";
			
			for (int j = 0; j<nStudents;j++) {
				ans += isMentorTo(studentsGrade, studentsGrade[j], j) + " " ;
			}

			solutions[i] = ans;
		}
		
		int i = 1;
		for (String solution : solutions) {
			System.out.println("Case #" + i + ": " + solution);
			i++;
		}

	}

	public static String isMentorTo(int students [] , int grade, int ith) {
		int highest = 0;
		
		int i = 0;
		for (int student:students) {
			if (student < grade*2 && i!= ith) {
				if (student>highest) {
					highest = student;
				}
			}
			i++;
		}
		if (highest != 0) {
			return Integer.toString(highest);
		}
		
		return "-1";
	}
}
