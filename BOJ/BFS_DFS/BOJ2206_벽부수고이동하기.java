package day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {

	private static int N, M, result;
	private static int[][] map;
	private static boolean[][][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		result = -1;
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0, 1 }); // 행, 열, 벽부쉈는가, 이동거리
		visited[0][0][0] = true;
		visited[1][0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			int wall = now[2];
			int cnt = now[3];
			if (row == N - 1 && col == M - 1) {
				result = cnt;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[wall][nr][nc]) {
					if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc, wall, cnt + 1 });
						visited[wall][nr][nc] = true;
					} else if (wall == 0) {
						q.offer(new int[] { nr, nc, 1, cnt + 1 });
						visited[1][nr][nc] = true;
					}
				}
			}
		}
	}
}
