import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667_단지번호붙이기 {

	private static int N;
	private static int[][] map;
	private static StringBuilder sb = new StringBuilder();
	private static int[] dr = { -1, 1, 0, 0 }; 
	private static int[] dc = { 0, 0, -1, 1 };
	private static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int totalCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					totalCount++;
				}
			}
		}

		Collections.sort(list);
		
		sb.append(totalCount).append('\n');
		for (int cnt : list) {
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		int count = 1;
		map[x][y] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (0 <= nr && nr < N && 0 <= nc && nc < N) {
					if (map[nr][nc] == 1) {
						q.offer(new int[] {nr, nc});
						count++;
						map[nr][nc] = 0;
					}
				}
			}
		}
		list.add(count);
	}



}
