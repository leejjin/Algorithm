package day0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> hash = new HashSet<String>(); 

		for (int i = 0; i < N; i++)
			hash.add(br.readLine()); //

		int cnt = 0;
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (hash.contains(s)) { // 듣보잡 찾아내기
				cnt++;
				result.add(s);
			}
		}
		Collections.sort(result); // 사전순 정렬
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for (String s : result) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}
}
