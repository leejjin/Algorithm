package day1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992_쿼드트리 {

	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		quadTree(0, 0, N);

		System.out.println(sb);
	}

	private static void quadTree(int r, int c, int size) {

		boolean isSame = true;

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[r][c] != map[i][j]) {
					isSame = false;
					break;
				}
			}
		}

		if (isSame) {
			sb.append(map[r][c]);
			return;
		}

		sb.append('(');
		quadTree(r, c, size / 2);
		quadTree(r, c + size / 2, size / 2);
		quadTree(r + size / 2, c, size / 2);
		quadTree(r + size / 2, c + size / 2, size / 2);
		sb.append(')');
	}
}
