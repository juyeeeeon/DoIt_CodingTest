package dataStructure.ex03_3_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count=0;

		for(int k=0; k<N; k++) {
			long M = arr[k];
			int i=0;
			int j=N-1;
			
			//투 포인터 알고리즘
			while(i<j) {
				if(arr[i]+arr[j] < M) i++;
				else if(arr[i]+arr[j] > M) j--;
				else { //음수도 고려
					if(i != k && j != k) {
						count++;
						break;
					}
					if(k==i) i++;
					else if(k==j) j--;
				}
			}
		}
		
		
		System.out.println(count);
	}

}
