package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940_주몽_풀이2_투포인터 {
	static int N, M, cnt = 0;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		int start = 0, end = N - 1;
		int total = 0;

		while (start < end) {
			total = nums[start] + nums[end];
			if (total == M) {
				cnt++;
				start++;
				end--;
			} else if (total < M)
				start++;
			else
				end--;
		}

		System.out.println(cnt);
	}
}
