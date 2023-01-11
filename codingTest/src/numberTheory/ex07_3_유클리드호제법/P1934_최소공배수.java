package numberTheory.ex07_3_유클리드호제법;

import java.util.Scanner;

public class P1934_최소공배수 {
	static int result = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result = a*b / gcd(a,b);
			System.out.println(result);
		}
	}
	
	//최대공약수 구하기
	//유클리드 호제법
	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return(gcd(b,a%b));
	}
}
