package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2448_별찍기11 {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][2 * N - 1];

		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		drawStar(0, N - 1, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void drawStar(int r, int c, int size) {
		if (size == 3) {
			map[r][c] = '*';
			map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
			map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
			return;
		}
		drawStar(r, c, size / 2); // 맨위 트리
		drawStar(r + size / 2, c - size / 2, size / 2); // 아래 왼쪽 트리
		drawStar(r + size / 2, c + size / 2, size / 2); // 아래 오른쪽 트리
	}

}
