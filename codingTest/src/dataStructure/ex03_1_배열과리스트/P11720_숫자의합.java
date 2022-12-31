package dataStructure.ex03_1_배열과리스트;

import java.util.Scanner;

public class P11720_숫자의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String sNum = sc.next();
		
		char[] cNum = sNum.toCharArray(); //문자열의 각 문자를 배열로
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			sum += cNum[i] - '0'; //문자를 숫자로
		}
		
		System.out.println(sum);
	}

}
