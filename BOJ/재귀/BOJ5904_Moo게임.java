package day210106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N번째 글자 구하기
// 수열의 길이
// S(0) : 0
// S(1) : 3
// S(2) : 3 / 4 / 3 = 10
// S(3) : 3/4/3 / 5 / 3/4/3 = 25
// S(4) : 3/4/3/5/3/4/3 / 6 / 3/4/3/5/3/4/3 = 56
// S(5) : 56 / 7 / 56 = 119

// 10^3 = 1000  2^10 = 1024
// 10^(3*3)		2^(10*3)
// 10^9 <= 2^30

//N = 45 이라면 , k = 4에서 moo(0,4) 호출
//mid = 0 + 25 + 6 = 31
//31 < 45  :  mid < N 이므로 moo(mid=31, k=3) 호출
//mid = 31 + 10 (3/4/3) + 3+2(5) = 46
//46 >= 45  :  mid >= N 이므로 if( 45 == 31 + 10 + 1 ) 판별 아니므로 o 출력 

public class BOJ5904_Moo게임 {

	static int N;
	static int[] S; // S(k)의 길이를 기억한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

		S = new int[50]; // 2^30에서 넉넉하게

		int k = 0;
		while (N > S[k]) {
			k++;
			S[k] = S[k - 1] * 2 + (k + 2); // 이전 수열의 길이 * 2 + 현재 k + 2
		}

		if (moo(0, k))
			System.out.println("m");
		else
			System.out.println("o");
	}

	// 이분 탐색
	private static boolean moo(int offset, int k) {
		int mid = offset + S[k - 1] + k + 2;

		if (N <= offset + S[k - 1])
			return moo(offset, k - 1);
		else if (N <= mid)
			return N == offset + S[k - 1] + 1; // M 인 경우
		else
			return moo(mid, k - 1);
	}

}
