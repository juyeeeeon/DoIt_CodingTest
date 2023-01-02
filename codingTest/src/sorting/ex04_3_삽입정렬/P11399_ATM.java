package sorting.ex04_3_삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//Arrays.sort(arr);
		
		//삽입정렬(O(N^2))로 구현해보기
		for(int i=1; i<N; i++) {
			int insert_ptr = i;
			int insert_val = arr[i];
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i]) {
					insert_ptr = j+1;
					break;
				}else if(j==0) insert_ptr = 0;
			}
			for(int k=i; k>insert_ptr; k--) {
				arr[k] = arr[k-1];
			}
			arr[insert_ptr] = insert_val;
		}
		
		
		//합 배열 : S[n] = a[n] + S[n-1]
		int[] S = new int[N];
		S[0] = arr[0];
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + arr[i];
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += S[i];
		}
		
		System.out.println(sum);
		
	}

}
