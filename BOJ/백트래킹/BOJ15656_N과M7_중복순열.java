package day1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656_N과M7_중복순열 {

	static int N, M;
	static int[] result, nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[M];
		nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		permutation(0);

		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			result[cnt] = nums[i];
			permutation(cnt + 1);
		}
	}
}
