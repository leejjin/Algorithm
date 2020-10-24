import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316_그룹단어체커 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			boolean[] check = new boolean[26];
			int prev = s.charAt(0) - 'a'; // 문자의 첫번째자리부터 이전 문자 탐색
			check[prev] = true; // 첫번째 문자 방문체크

			int j;
			for (j = 1; j < s.length(); j++) {
				int now = s.charAt(j) - 'a'; // 두번째자리 문자부터 탐색

				if (check[now]) { // 이미 방문한 문자라면
					if (prev == now) // 이전 문자와 같으면 계속 탐색
						continue;
					else // 이전 문자와 같지 않으면 그룹단어가 아니므로 탐색 종료
						break;
				} else // 처음 방문한 문자면 방문 체크
					check[now] = true;

				prev = now; // prev를 한 칸 이동시켜 저장
			}

			if (j == s.length()) // 문자열 탐색을 성공적으로 마쳤으면
				count++; // 카운트 증가
		}
		System.out.println(count);
	}
}