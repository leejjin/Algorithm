package day1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316_그룹단어체커_문자열_sol1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			boolean[] check = new boolean[26];
			int prev = s.charAt(0) - 'a'; // 문자의 첫번째자리부터 이전 문자 탐색
			check[prev] = true; // 첫번째 문자 방문체크

			boolean flag = true; // 그룹단어인지 판별할 flag 변수 

			for (int j = 1; j < s.length(); j++) {
				int now = s.charAt(j) - 'a'; // 두번째자리 문자부터 탐색
				
				if (check[now]) { // 이미 방문한 문자라면
					if (prev == now) // 이전 문자와 같으면 계속 탐색
						continue;
					else { // 이전 문자와 같지 않으면 그룹단어가 아니므로 탐색 종료
						flag = false;
						break;
					}
				}
				check[now] = true; // 방문체크
				prev = now; // prev 이동
			}
			if (flag) // 그룹단어라면 카운트
				count++;
		}

		System.out.println(count);
	}
}