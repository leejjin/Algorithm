package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 176ms
 */
public class BOJ4949_균형잡힌세상_풀이2_switch사용 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		testCase: while (true) {
			Stack<Character> stack = new Stack<>();
			boolean pair = true;

			char[] s = br.readLine().toCharArray();
			if (s[0] == '.') {
				System.out.println(sb);
				break;
			}

			for (char c : s) {
				switch (c) {
				case '(':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(')
						pair = false;
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[')
						pair = false;
					break;
				case '.':
					if (!stack.isEmpty())
						pair = false;
					if (pair)
						sb.append("yes\n");
					else
						sb.append("no\n");
					continue testCase;
				}
			}
		}
	}
}
