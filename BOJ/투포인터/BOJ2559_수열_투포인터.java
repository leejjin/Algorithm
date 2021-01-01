package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_수열_투포인터 {

	static int N, K;
	static int[] nums; // 누적된 합을 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		nums = new int[N];

		int sum = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if (i < K)
				sum += nums[i];
		}

		int start = 0, end = K - 1;
		int max = sum;

		while (end < N) {
			sum -= nums[start++];
			end++;
			if (end >= N)
				break;
			sum += nums[end];
			if (max < sum)
				max = sum;
		}

		System.out.println(max);
	}
}
