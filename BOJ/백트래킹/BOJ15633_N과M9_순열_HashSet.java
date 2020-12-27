package day1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ15633_N과M9_순열_HashSet {

	static int N, M;
	static int[] nums;
	static boolean[] used;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		used = new boolean[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		permutation(0, "");

		for (String s : set) {
			sb.append(s + "\n");
		}

		System.out.println(sb);
	}

	private static void permutation(int cnt, String s) {
		if (cnt == M) {
			set.add(s);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i])
				continue;

			used[i] = true;
			permutation(cnt + 1, s + nums[i] + " ");
			used[i] = false;
		}
	}
}
