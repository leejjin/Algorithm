package day1129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1158_요세푸스문제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		sb.append('<');
		int cur = K - 1;
		sb.append(list.remove(cur));
		while (!list.isEmpty()) {
			sb.append(", ");
			cur = (cur + K - 1) % list.size();
			sb.append(list.remove(cur));
		}
		sb.append('>');

		System.out.println(sb);
	}
}
