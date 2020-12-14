package day1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 거듭제곱 a^b % m
 * 
 * 2^10 = 2^5 * 2^5 => b가 홀수인 경우
 * 2^5 = 2^2 * 2^2 * 2 => b가 홀수인 경우 a를 한번 더 곱해준다.
 * 2^2 = 2^1 * 2^1 => b == 1인 경우 계산 결과 리턴
 */
public class BOJ1629_곱셈 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(Power(A, B, C));
	}

	private static long Power(int a, int b, int m) {

		if (b == 1)
			return a % m;

		long result = Power(a, b / 2, m);

		result = result * result % m;

		if (b % 2 == 0)
			return result;

		return result * a % m;
	}

}
