package dataStructure.ex03_1_배열과리스트;

import java.util.Scanner;

public class P1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double sum = 0;
		double max = 0;
		
		for(int i=0; i<N; i++) {
			int temp = sc.nextInt();
			sum += temp;
			if(temp>max) max = temp;
		}
		
		System.out.println(sum/max*100/N);
	}

}
