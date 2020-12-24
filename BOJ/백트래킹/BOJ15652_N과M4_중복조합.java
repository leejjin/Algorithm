package day1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652_N과M4_중복조합 {

	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		combination(1, 0);

		System.out.println(sb);
	}

	private static void combination(int start, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < cnt; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[cnt] = i;
			combination(i, cnt + 1);
		}
	}
}
