package day0224;

public class PRG_Level3_�ܾȯ {

	public int answer = 51;
	public boolean[] visited;

	public int solution(String begin, String target, String[] words) {

		visited = new boolean[words.length];

		dfs(0, begin, target, words);

		if (answer == 51) // ��� Ž�������� target�� ���� ���
			return 0;

		return answer;
	}

	private void dfs(int cnt, String now, String target, String[] words) {
		if (now.equals(target)) {
			if (answer > cnt)
				answer = cnt;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (!visited[i] && isDiffOneChar(now, words[i])) { // �湮 ���߰� �ѱ��ڸ� �ٸ���
				visited[i] = true; // �湮
				dfs(cnt + 1, words[i], target, words);
				visited[i] = false; // ����
			}
		}
	}

	// �� ���ڸ� �ٸ��� üũ
	private boolean isDiffOneChar(String now, String next) {
		int cnt = 0;
		for (int i = 0; i < now.length(); i++) {
			if (now.charAt(i) != next.charAt(i)) {
				cnt++;
				if (cnt > 1)
					return false;
			}
		}
		return true;
	}

}
