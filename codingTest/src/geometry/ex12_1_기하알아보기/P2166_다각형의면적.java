package geometry.ex12_1_기하알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2166_다각형의면적 {
	//다각형의 면적 = 절댓값(각 꼭지점들의 신발끈 공식의 값)/2
	//신발끈 공식은 좌표평면 상에서 꼭짓점의 좌표를 알 때 다각형의 면적을 구할 수 있는 방법
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		long[] x = new long[N+1];
		long[] y = new long[N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
		
		x[N] = x[0];
		y[N] = y[0];
		
		double result = 0;
		for(int i=0; i<N; i++) {
			result += x[i]*y[i+1] - x[i+1]*y[i];
		}
		
		String ans = String.format("%.1f", Math.abs(result)/2);
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
