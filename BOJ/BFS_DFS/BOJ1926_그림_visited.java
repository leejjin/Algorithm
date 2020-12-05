package day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926_그림_visited {

	public static int n, m;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dc = { 0, 0, -1, 1 };
	public static int count = 0, max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
		if (count == 0) // 그림이 없을 때를 고려해야한다.
			max = 0;
		System.out.println(count + "\n" + max);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;
		int temp = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int row = now[0];
			int col = now[1];
			temp++;

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr < n && nr >= 0 && nc < m && nc >= 0) {
					if (map[nr][nc] == 1 && !visited[nr][nc]) {
						queue.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}
		if (temp > max)
			max = temp;
	}
}
