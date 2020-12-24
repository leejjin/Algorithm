package day1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655_N과M6_조합 {

	static int N, M;
	static int[] result, nums;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		nums = new int[N];
		used = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		combination(0, 0);

		System.out.println(sb);
	}

	private static void combination(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			if (used[i])
				continue;
			result[cnt] = nums[i];
			used[i] = true;
			combination(i, cnt + 1);
			used[i] = false;
		}
	}
}
