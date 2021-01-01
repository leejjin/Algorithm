package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_수열_구간합 {

	static int N, K, max = Integer.MIN_VALUE;
	static int[] prefix_sum; // 누적된 합을 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		prefix_sum = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		int temp = 0;
		prefix_sum[0] = 0;
		for (int i = 1; i <= N; i++) {
			temp += Integer.parseInt(st.nextToken());
			prefix_sum[i] = temp;
		}

		for (int left = 1; left <= N - K + 1; left++) {
			int right = left + K - 1;
			if (right > N)
				continue;
			if (prefix_sum[right] - prefix_sum[left - 1] > max)
				max = prefix_sum[right] - prefix_sum[left - 1];
		}
		System.out.println(max);
	}
}
