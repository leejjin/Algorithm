package day1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012_괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 0; testCase < T; testCase++) {
			char[] arr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean isAble = true;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					stack.push('(');
					continue;
				} else {
					if (stack.isEmpty()) {
						isAble = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty())
				isAble = false;

			if (isAble)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		} // end of testCase
		System.out.println(sb);
	}
}
