package day1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258_큐2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();

		int num = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			switch (op) {
			case "push":
				num = Integer.parseInt(st.nextToken());
				queue.add(num);
				break;
			case "pop":
				if (!queue.isEmpty())
					sb.append(queue.poll() + "\n");
				else
					sb.append("-1\n");
				break;
			case "size":
				sb.append(queue.size() + "\n");
				break;
			case "empty":
				if (!queue.isEmpty())
					sb.append("0\n");
				else
					sb.append("1\n");
				break;
			case "front":
				if (!queue.isEmpty())
					sb.append(queue.peek() + "\n");
				else
					sb.append("-1\n");
				break;
			case "back":
				if (!queue.isEmpty())
					sb.append(num + "\n");
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
