package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 닫힌괄호 판별 => () 인가? 
 * 	1-1. 짝이 맞으면 레이저 
 * 		2. 레이저라고 판별되면 레이저에 의해 잘린 막대의 수를 스택의 크기로 알 수 있다.
 * 	1-2. 맞지 않으면 쇠막대기의 끝 
 * 		2. 스택에서 꺼낼 때마다 카운트해준다.
 */
public class BOJ10799_쇠막대기_스택풀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] op = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>(); // 괄호가 아닌 인덱스 값을 저장한다.

		int result = 0;
		for (int i = 0; i < op.length; i++) {
			switch (op[i]) {
			case '(':
				stack.push(i);
				break;
			case ')':
				if (stack.peek() == i - 1 && op[stack.peek()] == '(') {
					stack.pop();
					result += stack.size();
				}
				else {
					stack.pop();
					result++;
			}
				break;
			}
		}
		System.out.println(result);
	}
}
