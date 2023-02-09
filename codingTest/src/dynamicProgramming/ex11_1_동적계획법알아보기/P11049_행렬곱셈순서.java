package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11049_행렬곱셈순서 {
//https://www.youtube.com/watch?v=Tdl6VP4bS90 참고
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/*
		 * dp[i][j]에는 i번과 j번의 곱셈 횟수가 저장된다.

			예제처럼 3개의 행렬의 곱셈 횟수를 구하는 과정을 보면
			
			0번째 행렬과 1번째 행렬의 곱셈 횟수가 dp[0][1]에 저장되고
			
			1번째 행렬과 2번째 행렬의 곱셈횟수가 dp[1][2]에 저장되고
			
			0번째 행렬과 dp[1][2]와 곱해서 dp[0][2]에 저장되고
			
			2번째 행렬과 dp[0][1]과 곱해서
			
			전에 저장했던 dp[0][2]와 더 작은 값을 비교해서 dp[0][2]에 저장된다.
		 */
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//진짜 사람들 너무 똑똑하다ㅏㅏ
		for(int i=1; i<N; i++) {
			for(int j=0; j+i<N; j++) {
				dp[j][j+i] = Integer.MAX_VALUE;
				for(int k=j; k<j+i; k++)
					dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k]+dp[k+1][j+i] + arr[j][0]*arr[k][1]*arr[j+i][1]);
			}
		}
		System.out.println(dp[0][N-1]);
		
		
	}

}
