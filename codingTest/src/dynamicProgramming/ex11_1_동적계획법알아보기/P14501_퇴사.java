package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14501_퇴사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] D = new int[N+2]; //오늘부터 퇴사일까지 벌 수 있는 최대 수입
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		//이걸 어떻게 생각해내지
		for(int i=N; i>0; i--) {
			if(i+T[i] > N+1) { 
				D[i] = D[i+1];
		    }
		    else {
		    	D[i] = Math.max(D[i+1], P[i] + D[i+T[i]]);
		    }
		}
		
		bw.write(String.valueOf(D[1]));
		bw.flush();
		bw.close();
		br.close();
	}

}
