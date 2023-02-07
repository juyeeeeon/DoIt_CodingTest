package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P13398_연속합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		int[] dpDel = new int[n]; //수열에서 수 하나 제거
		int[] dp = new int[n]; //수열에서 수 제거x
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = input[0];
		dp[0] = dpDel[0] = input[0];
		
		//이걸 진짜 어떻게 생각할 수가 있지
		for(int i=1; i<input.length; i++) {
			dp[i] = Math.max(dp[i-1] + input[i], input[i]); //(자기 자신까지의 합, 자기자신의 값)
			dpDel[i] = Math.max(dp[i-1], dpDel[i-1] + input[i]); //(자기자신제거한경우, 자기자신보다 앞에서 이미 제거)
			max = Math.max(max, Math.max(dp[i], dpDel[i])); //수열에서 수 하나 제거한 경우와 안한 경우 중 큰 수
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}

}
