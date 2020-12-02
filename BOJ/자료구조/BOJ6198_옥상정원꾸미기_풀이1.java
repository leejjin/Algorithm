package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198_옥상정원꾸미기_풀이1 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Long> stack = new Stack<>();

		long result = 0;
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			Long top = Long.parseLong(br.readLine());

			while (!stack.isEmpty()) {
				if (stack.peek() > top)
					break;
				else
					stack.pop();
			}
			result += stack.size();
			stack.push(top);
		}
		System.out.println(result);
	}
}
