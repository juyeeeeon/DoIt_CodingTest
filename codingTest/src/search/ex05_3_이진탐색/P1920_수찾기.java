package search.ex05_3_이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN); //가장 중요한 부분!
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
//		int[] arrM = new int[M];
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<M; i++) {
//			arrM[i] = Integer.parseInt(st.nextToken());
//		}
//		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int sPtr = 0;
			int ePtr = arrN.length-1;
			int targetVal = Integer.parseInt(st.nextToken());
			boolean find = false;
			//pivot을 기준으로 찾으려는 값이 작으면 왼쪽, 크면 오른쪽 재탐색
			while(sPtr <= ePtr) {
				int pivot = (sPtr + ePtr) /2;
				if(arrN[pivot] < targetVal) sPtr = pivot + 1;
				else if(arrN[pivot] > targetVal) ePtr = pivot - 1;
				else {
					find = true;
					break;
				}
			}
			if(find) System.out.println("1");
			else System.out.println("0");
		}
	}

}
