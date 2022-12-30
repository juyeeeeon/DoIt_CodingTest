package ex03_2_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986_나머지합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long result = 0;
		long[] S = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		/* 내가 한 것  = 시간초과
		for(int i=0; i<N; i++) {
			for(int j=N; j>i; j--) {
				if((S[j]-S[i])%M == 0) result++;
			}
		}
		*/
		
		//BETTER
		//이 부분이 어려웠음
		long[] count = new long[M];
		for(int i=1; i<N+1; i++) {
			int remainder = (int) (S[i]%M);
			if(remainder == 0) result++;
			count[remainder]++;
		}
		
		for(int i=0; i<M; i++) {
			if(count[i]>=2) {
				result += (count[i]*(count[i]-1))/2;
			}
		}
		
		
		System.out.println(result);
	}

}
