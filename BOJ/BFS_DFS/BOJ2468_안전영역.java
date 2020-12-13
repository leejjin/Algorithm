package day1211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {

	private static int N, cnt, max = 0, height = -1;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (height < map[i][j])
					height = map[i][j];
			}
		}

		for (int h = 0; h < height; h++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[j], false);
			}
			cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > h && !visited[r][c]) {
						bfs(r, c, h);
						cnt++;
					}
				}
			}
			if (max < cnt)
				max = cnt;
		}

		System.out.println(max);
	}

	private static void bfs(int r, int c, int end) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] > end && !visited[nr][nc]) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
