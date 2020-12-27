package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15664_N과M10_조합_dfs {

	static int N, M;
	static int[] nums, result;
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

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}

		int prev = 0;
		for (int i = start; i < N; i++) {
			if (used[i])
				continue;

			if (i == 0 || prev != nums[i]) { // 이전에 방문한 값이 아니라면
				prev = nums[i];
				result[cnt] = nums[i];
				used[i] = true;
				combination(cnt + 1, i);
				used[i] = false;
			}
		}
	}
}
