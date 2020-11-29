import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1475_방번호 {

	static int[] check = new int[9];
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] room = br.readLine().toCharArray();

		for (int i = 0; i < room.length; i++) {
			int index = room[i] - '0';
			switch (index) {
			case 6:
			case 9:
				check[6]++;
				break;
			default:
				check[index]++;
				break;
			}
		}

		check[6] = check[6] / 2 + check[6] % 2;

		for (int i = 0; i < 9; i++) {
			if (result < check[i])
				result = check[i];
		}

		System.out.println(result);
	}
}
