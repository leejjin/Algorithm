package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003_수들의합2_풀이2_투포인터 {
	static int N, M;
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

		int cnt = 0;
		int start = 0, end = 0;
		int total = nums[0];

		while (end < N) {
			if (total == M)
				cnt++;

			if (total <= M) {
				end++;
				if (end == N)
					break;
				total += nums[end];
			} else {
				total -= nums[start];
				start++;
			}
		}
		System.out.println(cnt);
	}
}
