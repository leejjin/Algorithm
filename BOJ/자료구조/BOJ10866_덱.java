package day1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10866_덱 {

	static final int MX = 1000005;
	static int[] deque = new int[2 * MX + 1];
	static int head = MX, tail = MX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int num = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			switch (op) {
			case "push_front":
				deque[--head] = Integer.parseInt(st.nextToken());
				break;
			case "push_back":
				deque[tail++] = Integer.parseInt(st.nextToken());
				break;
			case "pop_front":
				if (head != tail)
					sb.append(deque[head++] + "\n");
				else
					sb.append("-1\n");
				break;
			case "pop_back":
				if (head != tail)
					sb.append(deque[--tail] + "\n");
				else
					sb.append("-1\n");
				break;
			case "size":
				sb.append(tail - head + "\n");
				break;
			case "empty":
				if (head != tail)
					sb.append("0\n");
				else
					sb.append("1\n");
				break;
			case "front":
				if (head != tail)
					sb.append(deque[head] + "\n");
				else
					sb.append("-1\n");
				break;
			case "back":
				if (head != tail)
					sb.append(deque[tail-1] + "\n");
				else
					sb.append("-1\n");
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}
}
