
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추 {

	private static int M, N, K; // 가로, 세로, 배추개수
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int count;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];

			int row, col;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}

			count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						count++;
						bfs(i, j);
					}
				}
			}

			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		map[x][y] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < M && 0 <= nc && nc < N) {
					if (map[nr][nc] == 1) {
						q.offer(new int[] { nr, nc });
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
}
