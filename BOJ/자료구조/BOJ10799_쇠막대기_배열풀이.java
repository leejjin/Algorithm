package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799_쇠막대기_배열풀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] op = br.readLine().toCharArray();

		int result = 0, count = 0;
		for (int i = 0; i < op.length; i++) {
			switch (op[i]) {
			case '(':
				count++;
				break;
			case ')':
				count--;
				if (op[i - 1] == '(') {
					result += count;
				} else {
					result++;
				}
				break;
			}
		}
		System.out.println(result);
	}
}
