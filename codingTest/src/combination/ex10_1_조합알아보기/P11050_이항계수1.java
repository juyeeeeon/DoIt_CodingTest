package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11050_이항계수1 {
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf(combination(N,K)));
		/*
		 * 이렇게도 풀 수 있음
		 * 
		 * int[][] C = new int[N+1][N+1];
		 * for(int i=0; i<C.length; i++){
		 * 		D[i][i] = 1;
		 * 		D[i][0] = 1;
		 * 		D[i][1] = i;
		 * }
		 * 
		 * for(int i=2; i<=N; i++){
		 * 		for(int j=1; j<i; j++){
		 * 			D[i][j] = D[i-1][j] + D[i-1][j-1];
		 * 		}
		 * }
		 */
		bw.flush();
		bw.close();
		br.close();
	}
	private static int combination(int n, int k) {
		if(n == k || k==0) return 1;
		else return combination(n-1, k) + combination(n-1, k-1);
	}

}
