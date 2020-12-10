package day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562_나이트의이동 {

	private static int I, er, ec;
	private static int[][] chess;
	private static boolean[][] visited;
	private static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int testCase = 0; testCase < T; testCase++) {
			I = Integer.parseInt(br.readLine());
			chess = new int[I][I];
			visited = new boolean[I][I];

			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());

			bfs(sr, sc);
		}
		System.out.println(sb);
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sr, sc });
		visited[sr][sc] = true;
		chess[sr][sc] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			if (row == er && col == ec) {
				sb.append(chess[row][col] + "\n");
			}

			for (int i = 0; i < 8; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < I && nc >= 0 && nc < I) {
					if (!visited[nr][nc]) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
						chess[nr][nc] = chess[row][col] + 1;
					}
				}
			}
		}
	}
}
