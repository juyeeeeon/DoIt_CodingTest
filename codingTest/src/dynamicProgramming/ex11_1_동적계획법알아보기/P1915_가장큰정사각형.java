package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1915_가장큰정사각형 {
	//https://yanoo.tistory.com/95 참고

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[][] d = new long[N][M];
		long max = 0;
		
		//어떻게 이걸 생각하지
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				d[i][j] = Long.parseLong(String.valueOf(input.charAt(j)));
				if(d[i][j] == 1 && j>0 && i>0) {
					d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j], d[i][j-1])) + d[i][j];
				}
				if(max < d[i][j]) max = d[i][j]; //max값은 정사각형의 한 변의 길이
			}
			
		}
		bw.write(String.valueOf(max*max));
		bw.flush();
		bw.close();
		br.close();
		
	}

}
