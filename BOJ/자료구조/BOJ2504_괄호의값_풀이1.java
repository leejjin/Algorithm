package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504_괄호의값_풀이1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String op = br.readLine();
		Stack<String> stack = new Stack<>();

		int result = 0;
		String prev;

		for (int i = 0; i < op.length(); i++) {
			char c = op.charAt(i);
			switch (c) {
			case '(':
			case '[':
				stack.push(Character.toString(c));
				break;
			case ')':
				if (stack.isEmpty() || "[".equals(stack.peek())) { // 올바른 괄호인지 판별
					System.out.println(0);
					return;
				}
				prev = stack.pop();
				if ("(".equals(prev)) {
					stack.push(String.valueOf(2));
				} else { // 스택에 숫자가 있는 경우
					int out = Integer.parseInt(prev);
					while (!stack.isEmpty() && !"(".equals(stack.peek())) {
						String in = stack.pop();
						if (!"(".equals(in) && !"[".equals(in)) { // 스택에 또 숫자가 있다면
							out += Integer.parseInt(in); // 더해준다.
						}
					}
					if (stack.isEmpty()) {
						System.out.println(0);
						return;
					}
					stack.pop();
					stack.push(String.valueOf(out * 2));
				}
				break;
			case ']':
				if (stack.isEmpty() || "(".equals(stack.peek())) { // 올바른 괄호인지 판별
					System.out.println(0);
					return;
				}
				prev = stack.pop();
				if ("[".equals(prev)) {
					stack.push(String.valueOf(3));
				} else { // 스택에 숫자가 있는 경우
					int out = Integer.parseInt(prev);
					while (!stack.isEmpty() && !"[".equals(stack.peek())) {
						String in = stack.pop();
						if (!"(".equals(in) && !"[".equals(in)) { // 스택에 또 숫자가 있다면
							out += Integer.parseInt(in); // 더해준다.
						}
					}
					if (stack.isEmpty()) {
						System.out.println(0);
						return;
					}
					stack.pop();
					stack.push(String.valueOf(out * 3));
				}
				break;
			}
		}
		while (!stack.isEmpty()) {
			if ("(".equals(stack.peek()) || "[".equals(stack.peek())) {
				System.out.println(0);
				return;
			}
			result += Integer.parseInt(stack.pop());
		}
		System.out.println(result);
	}
}
