import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_섬의개수 {

	private static int w, h; // 지도의 너비와 높이
	private static int[][] map; // 지도
	private static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 좌상부터 시계방향
	private static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of input

			int count = 0; // 섬의개수
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append('\n');

		} // end of while

		System.out.println(sb);

	}// end of main

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x, y});
		map[x][y] = 0; // 방문 표시

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];

			for (int i = 0; i < 8; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (0 <= nr && nr < h && 0 <= nc && nc < w) { // 지도 범위 체크
					if (map[nr][nc] == 1) {
						q.offer(new int[] {nr, nc});
						map[nr][nc] = 0;
					}
				}
			}
		}
	}


}// end of class
