package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1010_다리놓기 {
	static int N, M;
	static int[][] C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		C = new int[30][30];
		
		for(int i=1; i<30; i++) {
			C[i][i] = 1;
			C[i][0] = 1;
		}
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(combination(M,N)) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static int combination(int n, int k) {
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				C[i][j] = C[i-1][j] + C[i-1][j-1];
			}
		}
		return C[n][k];
	}

}
