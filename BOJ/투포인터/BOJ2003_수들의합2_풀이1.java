package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_수들의합2_풀이1_투포인터 {
	static int N, M, cnt = 0;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int end = 0, total = 0;
		for (int start = 0; start < N; start++) {
			for (; end < N && total < M; end++) {
				total += nums[end];
			}
			if (total == M)
				cnt++;
			total -= nums[start];
		}
		System.out.println(cnt);
	}
}
