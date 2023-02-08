package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1328_고층빌딩 {
	//https://lotuslee.tistory.com/118 참고
	//이 세상에는 천재들이 너무 많다
	static final int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		long[][][] d = new long[N+1][L+1][R+1];
		d[1][1][1] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=L; j++) {
				for(int k=1; k<=R; k++) {
					d[i][j][k] = (d[i-1][j][k] * (i-2) + (d[i-1][j][k-1] + d[i-1][j-1][k])) % mod;
				}
			}
		}
		
		/*
		 * 1. n-1개의 건물을 세웠을 때, 왼쪽에서 보이는 빌딩의 개수가 (l-1)개, 오른쪽에서 보이는 빌딩의 개수가

   				r개인 상태(dp[n-1][l-1][r])에서 가장 왼쪽에 n번째 빌딩을 세우는 경우

 

			2. n-1개의 건물을 세웠을 때, 왼쪽에서 보이는 빌딩 개수가 l개, 오른쪽에서 보이는 빌딩 개수가 (r-1)개인
			
			   상태(dp[n-1][l][r-1])에서 가장 오른쪽에 n번째 빌딩을 세우는 경우
			
			 
			
			3. n-1개의 건물을 세워을 때, 왼쪽에서 보이는 빌딩 개수가 l개, 오른쪽에서 보이는 빌딩 개수가 r개인 
			
			   상태(dp[n-1][l][r])에서 중간에 n번째 빌딩을 세우는 경우
			
			   이 때, 중간에 세울 수 있는 경우의 수는 양 끝을 제외한 (n-2)가지가 있다.

 
		 */
		
		bw.write(String.valueOf(d[N][L][R]));
		bw.flush();
		bw.close();
		br.close();
	}

}
