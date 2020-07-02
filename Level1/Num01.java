package level1;

public class Num01 {

	/*
	 * level1 2016³â
	 * https://programmers.co.kr/learn/courses/30/lessons/12901
	 */
	
	class Solution {
		public String solution(int a, int b) {

			int month[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			String days[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

			int day = 4;

			for (int i = 0; i < a - 1; i++) {
				day += month[i];
			}

			day += b;
			day %= 7;

			String answer = days[day];

			return answer;
		}
	}
}
