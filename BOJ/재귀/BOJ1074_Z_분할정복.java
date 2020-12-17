package day1215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z_분할정복 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int count = 0;
		int rh = (1 << N) / 2;
		int ch = rh;

		while (N-- > 0) {
			int temp = (1 << N) / 2; // 2^N /2
			int size = 1 << (2 * N); //4^N
			if (r < rh && c < ch) {
				rh -= temp;
				ch -= temp;
			} else if (r < rh && c >= ch) {
				rh -= temp;
				ch += temp;
				count += size;
			} else if (r >= rh && c < ch) {
				rh += temp;
				ch -= temp;
				count += size * 2;
			} else {
				rh += temp;
				ch += temp;
				count += size * 3;
			}
		}
		System.out.println(count);
	}
}
