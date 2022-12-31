package dataStructure.ex03_3_투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class P1940_주몽 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); //배열 오름차순 정렬
		
		int i=0;
		int j=N-1;
		int count=0;
		
		while(i<j) {
			if(arr[i]+arr[j] < M) {
				i++;
			}else if(arr[i]+arr[j] > M) {
				j--;
			}else if(arr[i]+arr[j] == M) {
				count++;
				i++;
			}
		}
		System.out.println(count);
	}

}
