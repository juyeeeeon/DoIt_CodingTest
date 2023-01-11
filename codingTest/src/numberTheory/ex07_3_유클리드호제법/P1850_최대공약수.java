package numberTheory.ex07_3_유클리드호제법;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1850_최대공약수 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		
		/*
		 * 결과값은 두 정수가 가진 1의 개수의 최대공약수만큼 1을 나열한 수가 된다
		 * (이걸 어떻게 알고있지..)
		 */
		long result = gcd(a,b);
		while(result > 0) {
			bw.write("1");
			result--;
		}
		
		bw.flush();
		bw.close();
		
		//메모리 초과
		//long inputA = Long.parseLong("1".repeat((int) a));
		//long inputB = Long.parseLong("1".repeat((int) b));
		
		
		System.out.println(gcd(a,b));
	}

	//최대공약수 구하기
	//유클리드 호제법
	private static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b,a%b);
	}

}
