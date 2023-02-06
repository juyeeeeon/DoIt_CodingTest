package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1463_1로만들기 {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[0] = dp[1] = 0;
		
		/*
		 * x가 3으로 나누어 떨어지면 3으로 나눈다는 소리는
		 * n/3 을 한 수의 최단 횟수에서 한 번만 더 해 준다는 말과 같음
		 */
		for(int i=2; i<dp.length; i++) { //어떻게 이걸 생각하지
			dp[i] = dp[i-1] + 1;
			if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
		}
		
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}
}
