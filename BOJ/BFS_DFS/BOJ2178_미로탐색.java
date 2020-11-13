
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2178_미로탐색 {

	private static int[][] map;
	private static int N, M;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			
			if(row==N-1 && col == M-1) {
				System.out.println(map[row][col]);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < M) {
					if (map[nr][nc] == 1) {
						q.offer(new int[] { nr, nc });
						map[nr][nc] = map[row][col] + 1;
					}
				}
			}
		}
	}
}
