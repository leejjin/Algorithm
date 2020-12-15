package day1214;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729_하노이탑이동순서 {

	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		hanoi(K, 1, 2, 3);

		System.out.println(count);
		System.out.println(sb);
	}

	private static void hanoi(int k, int from, int by, int to) {
		count++;
		if (k == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		hanoi(k - 1, from, to, by); // from -> by
		sb.append(from + " " + to + "\n"); // from -> to
		hanoi(k - 1, by, from, to); // by -> to
	}
}
