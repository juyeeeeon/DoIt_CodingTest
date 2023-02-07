package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2193_이친수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		
		dp[0] = 0;
		dp[1] = 1; // 1
		//dp[2] = 1; // 10
		//dp[3] = 2; // 100 101
		//dp[4] = 3; // 1000 1001 1010
		//dp[5] = 5;//10000 10001 10010 10100 10101 
		//dp[6] = //100000 100001 100010 100101 100100 101000 101010 101001 
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}

}
