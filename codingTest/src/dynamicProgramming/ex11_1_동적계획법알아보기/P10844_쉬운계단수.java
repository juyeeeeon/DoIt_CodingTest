package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10844_쉬운계단수 {
	static final long mod = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		//N자릿수에 각각의 자릿값(0~9)에 따른 경우의 수
		long[][] dp = new long[N+1][10];
		
		//한 자릿수는 1~9까지 모두 1
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		//이걸 생각하는게 너무 어렵당
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][1];	//마지막 자리의 값이 0이면 그 앞자리는 1밖에 올 수 없음
			dp[i][9] = dp[i-1][8];	//마지막 자리의 값이 9이면 그 앞자리는 8밖에 올 수 없음
			for(int j=1; j<=8; j++) { //마지막 자리의 값이 나머지 1~8 이라면 그 앞자리는 +1이거나 -1이거나
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
			}
		}
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum = (sum + dp[N][i]) % mod;
		}
		
		
		bw.write(String.valueOf(sum));
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
