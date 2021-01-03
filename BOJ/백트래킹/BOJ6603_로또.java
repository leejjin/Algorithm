package day210101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603_로또 {

	static int K;
	static int[] lotto, nums;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken());

			if (K == 0)
				break;

			nums = new int[K];
			used = new boolean[K];
			lotto = new int[6];

			for (int i = 0; i < K; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);

			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void combination(int start, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(lotto[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < K; i++) {
			if (used[i])
				continue;
			lotto[cnt] = nums[i];
			used[i] = true;
			combination(i, cnt + 1);
			used[i] = false;
		}
	}
}
