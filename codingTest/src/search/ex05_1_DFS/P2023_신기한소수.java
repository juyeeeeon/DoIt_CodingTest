package search.ex05_1_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2023_신기한소수 {
	//아이디어가 어렵다
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		//일의 자리 소수는 2,3,5,7 이므로 4개의 수에서만 시작
		//숫자를 쌓아올림
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}

	private static void DFS(int number, int jarisu) {
		if(jarisu == n) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for(int i=1; i<10; i++) {
			if(i%2 == 0) continue;  // 짝수이면 더 이상 탐색할 필요가 없음
			if(isPrime(number*10+i)) DFS(number*10+i, jarisu+1); // 소수이면 재귀로 자리수를 늘려갑니다.
		}
	}

	private static boolean isPrime(int number) {
		for(int i=2; i<=number/2; i++) {
			if( number % i == 0)
				return false;
		}
		return true;
	}

}
