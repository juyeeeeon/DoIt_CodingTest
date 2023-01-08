package search.ex05_3_이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1300_K번째수 {
	//이진탐색을 어떻게 적용해야하는지가 어렵다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		long low = 1;
		long high = k; // n * n은 안되고 k는 되는 이유 ? 
					   // -> 무조건 내가 찾으려는 값은 K보다 작기 때문 (같은 수가 무조건 여러개 존재하기 때문)
		long result = 0;
		
		while(low <= high) {
			long mid = (low+high)/2;
			long cnt = 0;
			
			//중간 값보다 작은 수는 몇 개인지 계산
			for(int i=1; i<N+1; i++) {
				cnt += Math.min(mid/i, N); // 작은 수를 카운트하는 핵심로직!!, i번째 행
											//https://maivve.tistory.com/151 참고
			}
			if(cnt < k) low = mid + 1;
			
			//같은 수가 여러개 존재하기 때문에 cnt값이 1차이로 작이지거나 커지지 않음
			//따라서 cnt == k 가 안될수도 있음.
//			else if(cnt > k) high = mid - 1;
//			else {
//				result = mid;
//				break;
//			}
			
			else {
				result = mid;
				high = mid-1;
			}
		}
		
		System.out.println(result);
		
		/*
		 * 메모리 초과
		int[] B = new int[N*N+1];
		
		int tmp=1;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				B[tmp] = i*j;
				tmp++;
			}
		}
		
		Arrays.sort(B);//평균 : O(nlog(n)) / 최악 : O(n^2)
		
		System.out.println(B[k]);
		*/
		
		
	}

}
