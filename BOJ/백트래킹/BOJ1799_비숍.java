package day0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1799_��� {

	static int N; // ü������ ũ��
	static int[] answer = new int[2]; // ����, ��� ĭ�� ����� ��
	static int[][] chess; // ü����. ����� ���� �� ���� ���� 0���� ǥ��
	static boolean[][] color; // ü����ó�� ���� ĭ�� �����
	static boolean[][] visited;
	static int[] dr = { -1, -1 }; // �»� ���
	static int[] dc = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		color = new boolean[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
				// color �迭�� ���� ü����ó�� ���� ǥ�ø� ��
				color[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
			}
		}

		// -1 : ó�� ������ �� ����� ���� �ʴ� ��� üũ
		solve(-1, true, 0);
		solve(-1, false, 0);

		System.out.println(answer[0] + answer[1]);
	}

	private static void solve(int idx, boolean isBlack, int cnt) {
		// ���� for ���� ������� �ʰ� N*N Ž��
		for (int i = idx + 1; i < N * N; i++) {
			int r = i / N;
			int c = i % N;

			// ü���ǿ� ���� �� ���� ���̰ų�, ������ ��ġ���� ������ ����� ���� �� ����
			if (chess[r][c] == 0 || color[r][c] != isBlack)
				continue;

			if (dfs(r, c)) {
				visited[r][c] = true;
				solve(i, isBlack, cnt + 1); // cnt : ����� �� ī��Ʈ
				visited[r][c] = false;
			}
		}

		if (isBlack) // ������ ��
			answer[0] = Math.max(answer[0], cnt);
		else // ����� ��
			answer[1] = Math.max(answer[1], cnt);
	}

	// ���� ��ġ���� ����� ���� �� �ִ°� dfs�� ���� �Ǻ���
	private static boolean dfs(int r, int c) {

		// ���� ��ġ���� �Ʒ����� ����� ���� ����, ������ ����� ���� �� �ִ� �����̴�.
		// �׷��Ƿ� ���ʿ� ����� �ִ����� �Ǻ����ָ� �ǹǷ� �»�, ��� Ž���Ѵ�.
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			for (int j = 0; j < N; j++) {
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc]) // ����� ������ false ����
					return false;

				// �밢�� �̵�
				nr += dr[i];
				nc += dc[i];
			}

		}
		// ����� ���� �� ����
		return true;
	}
}
