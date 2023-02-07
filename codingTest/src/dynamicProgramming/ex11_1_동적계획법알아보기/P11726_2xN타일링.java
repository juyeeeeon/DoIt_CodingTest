package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11726_2xN타일링 {
	static final int mod = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		
		dp[0] = 1;
		dp[1] = 1;

		for(int i=2; i<dp.length; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%mod;
		}
		
		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
		
	}
}

	