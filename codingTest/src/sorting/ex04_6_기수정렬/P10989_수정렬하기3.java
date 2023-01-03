package sorting.ex04_6_기수정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10989_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//기수정렬으로 구현해보기
		radixSort(arr,5);
		
		//Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			bw.write(String.valueOf(arr[i]+"\n"));
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static void radixSort(int[] arr, int max_size) {
		int[] output = new int[arr.length];
		int jarisu = 1;
		int count = 0;
		
		while(count!=max_size) {
			int[] bucket = new int[10];
			for(int i=0; i<arr.length; i++) {
				bucket[(arr[i]/jarisu)%10]++; //일의 자리부터 시작
			}
			for(int i=1; i<10; i++) {	//합배열을 이용하여 index 계산
				bucket[i] += bucket[i-1];
			}
			for(int i= arr.length-1; i>=0; i--) {// 현재 자리수 기준으로 정렬하기
				output[bucket[(arr[i]/jarisu%10)]-1] = arr[i];
				bucket[(arr[i]/jarisu)%10]--;
			}
			for (int i = 0; i < arr.length; i++) {
		        arr[i] = output[i]; // 다음 자리 수 이동을 위해 현재 자리수 기준 정렬 데이터 저장
		    }
		    jarisu = jarisu * 10; // 자리수 증가
		    count++;
		}
	}

}
