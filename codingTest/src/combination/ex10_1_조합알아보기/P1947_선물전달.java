package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1947_선물전달 { 
	//점화식 찾는게 어렵다
	static long N;
	static final long mod = 1000000000;
	static long[] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Long.parseLong(br.readLine());
		D = new long[1000001];
		
		D[1] = 0;
		D[2] = 1;
		for(int i=3; i<=N; i++) { //점화식 D[i] = (i-1)*(D[i-1] + D[i-2])
			D[i] = (i-1)*(D[i-1] + D[i-2])%mod;
		}
		
		bw.write(String.valueOf(D[(int)N]));
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
