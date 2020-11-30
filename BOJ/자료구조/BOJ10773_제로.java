package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			switch (num) {
			case 0:
				if (!stack.isEmpty())
					stack.pop();
				break;
			default:
				stack.push(num);
				break;
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}
