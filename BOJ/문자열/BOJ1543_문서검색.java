package day1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543_문서검색 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();
		int count = 0;
		
		str = str.replaceAll(target, "0");
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '0')
				count++;
		}
		System.out.println(count);
	}
}
