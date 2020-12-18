package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2447_별찍기10 {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 3의 거듭제곱
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		drawStar(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void drawStar(int r, int c, int size) {
		if (size == 1) {
			map[r][c] = '*';
			return;
		}

		int s = size / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				else
					drawStar(r + s * i, c + s * j, s);
			}
		}
	}

}
