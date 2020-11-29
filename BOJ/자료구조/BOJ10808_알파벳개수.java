import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808_알파벳개수 {

	public static int[] alphabet = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String keyword = br.readLine();

		for (int i = 0; i < keyword.length(); i++) {
			alphabet[keyword.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]).append(' ');
		}
		System.out.println(sb);
	}
}
