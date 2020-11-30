package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828_스택_STL {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			switch (op) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (!stack.isEmpty())
					sb.append(stack.pop() + "\n");
				else
					sb.append("-1" + "\n");
				break;
			case "size":
				sb.append(stack.size() + "\n");
				break;
			case "empty":
				if (stack.isEmpty())
					sb.append("1" + "\n");
				else
					sb.append("0" + "\n");
				break;
			case "top":
				if (!stack.isEmpty())
					sb.append(stack.peek() + "\n");
				else
					sb.append("-1" + "\n");
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}
}
