package sorting.ex04_1_버블정렬;

import java.util.Arrays;
import java.util.Scanner;

public class P2750_수정렬하기 {
	//매우 쉬운 문제
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		//버블정렬(O(n^2))으로 풀어보기
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
		
		//Arrays.sort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
