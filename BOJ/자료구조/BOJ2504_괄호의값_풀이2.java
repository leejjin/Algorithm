package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * temp에는 현재 계산되고 있는 값들을 담는다. 
 * result에는 계산이 완료된 값을 더해준다. 
 * 열린 괄호일 때 ( : 2, [ : 3을 temp에 곱한다. 
 * 각 괄호에 맞는 닫힌 괄호가 나왔을 때 temp는 계산을 마치며, result에 더해준다. 
 * result에 더한 값을 뺀 값만 temp 에 남긴다.
 */
public class BOJ2504_괄호의값_풀이2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] op = br.readLine().split("");

		if (op.length % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		Stack<String> stack = new Stack<>();
		int result = 0;
		int temp = 1;
		for (int i = 0; i < op.length; i++) {
			String s = op[i];
			if ("(".equals(s)) {
				temp *= 2;
				stack.push("(");
			} else if ("[".equals(s)) {
				temp *= 3;
				stack.push("[");
			} else if (")".equals(s)) {
				if (stack.isEmpty() || !"(".equals(stack.peek())) {
					System.out.println(0);
					return;
				}
				if ("(".equals(op[i - 1]))
					result += temp;
				stack.pop();
				temp /= 2;

			} else if ("]".equals(s)) {
				if (stack.isEmpty() || !"[".equals(stack.peek())) {
					System.out.println(0);
					return;
				}
				if ("[".equals(op[i - 1]))
					result += temp;
				stack.pop();
				temp /= 3;
			}
		}
		System.out.println(result);
	}
}
