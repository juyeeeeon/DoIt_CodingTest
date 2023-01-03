package sorting.ex04_5_병합정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2751_수정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//병합정렬(O(nlogn))으로 구현해보기
		
		mergeSort(arr, n);
		
		//Arrays.sort(arr);
		
		for(int i =0; i<n; i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int[] buff;
	
	private static void __mergeSort(int[] arr, int left, int right) {
		if(left<right) {
			int i;
			int center = (left+right)/2;
			int p=0;
			int j=0;
			int k=left;
			
			__mergeSort(arr, left, center);
			__mergeSort(arr, center+1, right);
			
			for(i=left; i<=center; i++) buff[p++] = arr[i]; //left~center까지 버퍼로 옮김
			while(i<=right && j<p) arr[k++]=(buff[j]<=arr[i])?buff[j++]:arr[i++]; //buffer로 옮긴 값과 기존 배열의 center+1~right 비교
			while(j<p) arr[k++] = buff[j++]; //buff의 남은 값 넣기
		}
	}

	private static void mergeSort(int[] arr, int n) {
		buff = new int[n];
		
		__mergeSort(arr,0,n-1);
		
		buff=null;
	}

}
