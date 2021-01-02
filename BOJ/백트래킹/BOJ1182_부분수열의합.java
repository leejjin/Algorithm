package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합 {
	static int N, S, cnt = 0;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 0);

		if (S == 0)
			cnt--;
		System.out.println(cnt);
	}

	private static void powerSet(int idx, int total) {
		if (idx == N) {
			if (total == S)
				cnt++;
			return;
		}
		powerSet(idx + 1, total);
		powerSet(idx + 1, total + nums[idx]);
	}
}
