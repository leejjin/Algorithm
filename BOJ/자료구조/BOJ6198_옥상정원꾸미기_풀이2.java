package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198_옥상정원꾸미기_풀이2 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();

		long result = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			// 스택에 arr[i]보다 작은 높이의 빌딩은 꺼내서 버리기
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			// 스택의 크기 = arr[i]보다 큰 빌딩의 수
			result += stack.size();
			// arr[i]보다 큰 빌딩이 있으면 그 위에 내 것 쌓기
			stack.push(arr[i]);
		}

		System.out.println(result);
	}
}
