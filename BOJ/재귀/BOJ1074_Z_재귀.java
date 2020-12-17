package day1215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z_재귀 {

	private static int N, r, c, count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N);

		recur(0, 0, N);
	}

	private static void recur(int x, int y, int size) {

		if (size == 1) {
			if (x == r && y == c)
				System.out.println(count);
			count++;
			return;
		}

		int half = size / 2;

		recur(x, y, half);
		recur(x, y + half, half);
		recur(x + half, y, half);
		recur(x + half, y + half, half);
	}
}
