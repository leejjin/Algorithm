package day1203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4889_안정적인문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = 1;
		while (true) {
			char[] arr = br.readLine().toCharArray();
			if (arr[0] == '-')
				break;

			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '{') {
					stack.push('{');
					continue;
				} else { // } 일 때
					if (!stack.isEmpty() && stack.peek() == '{')
						stack.pop();
					else
						stack.push('}');
				}
			}

			while (!stack.isEmpty()) {
				char c1 = stack.pop();
				char c2 = stack.pop();
				if(c1==c2) // {{ or }} 인 경우
					cnt++;
				else	// }{ 인 경우
					cnt+=2;
			}

			sb.append(TC++).append(". ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
