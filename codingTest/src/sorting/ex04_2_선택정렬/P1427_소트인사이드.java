package sorting.ex04_2_선택정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1427_소트인사이드 {

	public static void main(String[] args) {
		//선택정렬(O(n^2)) 이용하여 풀기
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int[] arr = new int[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		//선택정렬
		for(int i=0; i<str.length(); i++) {
			int max = i;
			for(int j=i+1; j<str.length(); j++) {
				if(arr[j]>arr[max]) max=j;
			}
			if(arr[i]<arr[max]) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}
		
		for(int i : arr) {
			System.out.print(i);
		}
		
		/* 내가 푼 답
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<str.length(); i++) {
			arr.add(str.charAt(i) - '0');
		}
		
		Collections.sort(arr);
		Collections.reverse(arr);
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i));
		}
		*/
	}
}
