package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		int idx = 1;
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (flag) {
				if (idx <= num) {
					while (idx <= num) {
						stack.push(idx++);
						sb.append("+\n");
					}
				}
				if (stack.isEmpty())
					flag = false;
				else {
					while (stack.peek() >= num) {
						stack.pop();
						sb.append("-\n");
						if (stack.isEmpty())
							break;
					}
				}
			}
		}
		
		if(flag)
			System.out.println(sb);
		else
			System.out.println("NO");
	}
}
