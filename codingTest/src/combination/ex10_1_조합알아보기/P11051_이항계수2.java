package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11051_이항계수2 {
	static int N, K;
	static final int num = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] C = new int[N+1][N+1];
		for(int i=0; i<C.length; i++) {
			C[i][i] = 1;
			C[i][0] = 1;
			//C[i][1] = i;
		}
		
		for(int i=2; i<C.length; i++) {
			for(int j=1; j<i; j++) {
				C[i][j] = C[i-1][j-1]%num + C[i-1][j]%num;
			}
		}
		bw.write(String.valueOf(C[N][K]%num));
		
		//bw.write(String.valueOf(combination(N, K)%num));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	/*
	private static int combination(int n, int k) {
		if(k == 0 || n == k) return 1;
		else if(k==1) return n%num;
		else return combination(n-1, k)%num + combination(n-1, k-1)%num;
	}*/

}
