package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class BOJ1406_에디터_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] str = br.readLine().toCharArray();
		int M = Integer.parseInt(br.readLine());

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for (int i = 0; i < str.length; i++) {
			left.push(str[i]);
		}

		for (int i = 0; i < M; i++) {
			String op = br.readLine();
			switch (op.charAt(0)) {
			case 'L':
				if (!left.isEmpty())
					right.push(left.pop());
				break;
			case 'D':
				if (!right.isEmpty())
					left.push(right.pop());
				break;
			case 'B':
				if (!left.isEmpty()) {
					left.pop();
				}
				break;
			case 'P':
				left.push(op.charAt(2));
				break;
			}
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}
}
