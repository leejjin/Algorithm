package day1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649_N과M1_순열 {

	static int N, M;
	static int[] arr;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		used = new boolean[N + 1];

		permutation(0);

		System.out.println(sb);
	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (used[i])
				continue;
			else {
				arr[cnt] = i;
				used[i] = true;
				permutation(cnt + 1);
				used[i] = false;
			}
		}
	}
}
