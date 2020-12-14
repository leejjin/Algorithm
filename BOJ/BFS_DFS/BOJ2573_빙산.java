package day1211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1. 빙산의 덩어리 수 구하기 
// => 빙산이 2개 이상 나뉠 때까지 DFS를 돌며 확인한다.
// => 빙산이 0일 경우 (모두 녹은 경우)는 0을 출력한다.
// 2. 빙산 녹이기
// => 빙산과 인접한 바다의 수를 다른 배열에 저장하고, DFS가 끝나면 빙산을 감소시킨다.

public class BOJ2573_빙산 {

	private static int N, M;
	private static int[][] map;
	private static int[][] melt;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		melt = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0 && !visited[r][c]) {
						dfs(r, c);
						cnt++;
					}
				}
			}

			if (cnt == 0) {
				System.out.println(0);
				return;
			} else if (cnt >= 2) {
				System.out.println(year);
				return;
			}

			melting();
			year++;
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (map[nr][nc] == 0)
					melt[r][c]++;
				if (!visited[nr][nc] && map[nr][nc] != 0)
					dfs(nr, nc);
			}
		}
	}

	private static void melting() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					map[i][j] = (map[i][j] - melt[i][j] < 0) ? 0 : map[i][j] - melt[i][j];
					visited[i][j] = false;
					melt[i][j] = 0;
				}
			}
		}
	}
}
