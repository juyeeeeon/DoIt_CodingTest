package search.ex05_3_이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_기타레슨 {
	//이진탐색을 어떻게 적용해야할지가 어렵다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		
		/*
		 * 임의의 블루레이 크기를 정하여 담아 본 다음, 
		 * 블루레이 갯수(count)가 인풋에서 제한한 갯수(M)보다 
		 * 많아지면 블루레이 크기를 늘려야겠고, (start = pivot + 1)
		 * 적어지면 블루레이 크기를 줄여야 (end = pivot - 1)
		 */
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(start < arr[i]) start = arr[i];  //arr의 최댓값을 시작 인덱스로 저장(최소 블루레이 크기)
			end += arr[i];	//arr의 총합을 종료 인덱스로 저장(최대 블루레이 크기)
		}
		
		//이진탐색 시작
		
		while(start <= end) {
			int pivot = (start+end)/2; //임시로 가정할 블루레이의 크기
			int sum = 0;
			int count = 0;
			
			for(int i=0; i<N; i++) { //pivot값으로 모든 레슨을 저장할 수 있는지 확인
				if(sum + arr[i] > pivot) {
					count++; //필요한 블루레이 갯수를 한개 증가
					sum = 0;
				}
				sum += arr[i];
			}
			
			if(sum != 0) count++;
			if(count > M) start = pivot + 1; //블루레이 갯수가 M보다 많다면 블루레이 1개당 크기를 늘려야
			else end = pivot - 1; //블루레이 갯수가 M보다 적다면 블루레이 1개당 크기를 줄여야
		}
		
		System.out.println(start);
	}

}
