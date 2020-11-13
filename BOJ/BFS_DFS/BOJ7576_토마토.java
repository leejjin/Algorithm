
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ7576_토마토 {
	private static int[][] map;
	private static int N, M, count;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static Queue<int[]> q = new LinkedList<>(); // int[] : 행,열,날짜

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count = -1;
					break;
				}
			}
		}
		System.out.println(count);
	}

	private static void bfs() {
		// 토마토 위치를 큐에 넣음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					q.offer(new int[] { i, j, 0 });
				}
			}
		}
		count = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			count = now[2];

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < M) {
					if (map[nr][nc] == 0) {
						q.offer(new int[] { nr, nc, count + 1 });
						map[nr][nc] = 1;
					}
				}
			}
		}

	}

}
