package day1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17880_종이의개수 {

	static int N, minus = 0, zero = 0, one = 0;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);

		sb.append(minus + "\n" + zero + "\n" + one);
		System.out.println(sb);

	}

	private static void divide(int r, int c, int size) {

		boolean isSame = true;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != map[r][c]) {
					isSame = false;
					break;
				}
			}
		}

		if (isSame) {
			switch (map[r][c]) {
			case -1:
				minus++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				one++;
				break;
			}
			return;
		}

		int s = size / 3;
		divide(r, c, s);
		divide(r, c + s, s);
		divide(r, c + s * 2, s);
		divide(r + s, c, s);
		divide(r + s, c + s, s);
		divide(r + s, c + s * 2, s);
		divide(r + s * 2, c, s);
		divide(r + s * 2, c + s, s);
		divide(r + s * 2, c + s * 2, s);
	}
}
