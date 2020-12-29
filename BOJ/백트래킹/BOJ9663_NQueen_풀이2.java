package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663_NQueen_풀이2 {

	static int N, queen = 0;
	static int[] map;
	static boolean[] col, diagonal1, diagonal2; // 열확인, ／ 대각선 확인, ＼ 대각선 확인

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		col = new boolean[N];
		diagonal1 = new boolean[N + N - 1];
		diagonal2 = new boolean[N + N - 1];

		setQueens(0);
		System.out.println(queen);
	}

	private static void setQueens(int row) {
		if (row == N) {
			queen++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (col[i] || diagonal1[i + row] || diagonal2[i - row + N - 1])
				continue;
			map[row] = i;
			col[i] = true;
			diagonal1[i + row] = true;
			diagonal2[i - row + N - 1] = true;
			setQueens(row + 1);
			col[i] = false;
			diagonal1[i + row] = false;
			diagonal2[i - row + N - 1] = false;
		}
	}
}
