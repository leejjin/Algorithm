package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828_스택_구현 {

	static final int MX = 10005;
	static int[] stack = new int[MX];
	static int pos = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			switch (op) {
			case "push":
				stack[++pos] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if (pos != -1)
					sb.append(stack[pos--] + "\n");
				else
					sb.append("-1" + "\n");
				break;
			case "size":
				sb.append(pos + 1 + "\n");
				break;
			case "empty":
				if (pos == -1)
					sb.append("1" + "\n");
				else
					sb.append("0" + "\n");
				break;
			case "top":
				if (pos != -1)
					sb.append(stack[pos] + "\n");
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
