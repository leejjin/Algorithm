package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663_NQueen_풀이1 {

	static int N, queen = 0;
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];

		setQueens(0);
		System.out.println(queen);
	}

	private static void setQueens(int row) {
		if (row == N) {
			queen++;
			return;
		}

		for (int i = 0; i < N; i++) {
			map[row] = i;
			if (checkCol(row))
				setQueens(row + 1);
		}
	}

	private static boolean checkCol(int row) {

		for (int i = 0; i < row; i++) {
			if (map[row] == map[i] || Math.abs(map[row] - map[i]) == row - i)
				return false;
		}
		return true;
	}

}
