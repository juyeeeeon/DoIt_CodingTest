package dataStructure.ex03_2_구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_구간합구하기4 {
	//합 배열 공식 : S[i] = S[i-1] + A[i]
	//구간 합 공식 : S[j] - S[i-1]
	public static void main(String[] args) throws IOException {
		
		//N과 M이 10만개이므로 Scanner 보다 빠른 BufferedReader 사용
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));
		
		//StringTokenizer 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 왠만해서 int보다 long으로 선언하는게 범위오류 덜함
		long[] S = new long[N + 1]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int q=0; q<M; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			System.out.println(S[j]-S[i-1]);
		}	
		
		/* 내가 한것
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] S = new int[N];
		int result = 0;
		
		S[0] = sc.nextInt();
		
		for(int i=1; i<N; i++) {
			int temp = sc.nextInt();
			S[i] = S[i-1] + temp;
		}
		
		for(int k=0; k<M; k++) {
			int i = sc.nextInt()-2;
			int j = sc.nextInt()-1;
			
			if(i<0) result = S[j];
			else result = S[j] - S[i];
			System.out.println(result);
		}
		 */
	}

}
