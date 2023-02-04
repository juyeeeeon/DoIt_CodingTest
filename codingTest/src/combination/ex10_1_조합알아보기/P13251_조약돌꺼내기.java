package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P13251_조약돌꺼내기 {
	static int M, K;
	static int[] N;
	static double[] prob;
	static int[][] C;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		M = Integer.parseInt(br.readLine()); //색상의 개수
		N = new int[M]; //각 색상의 조약돌의 개수
		prob = new double[M];
		sum = 0; //전체 조약돌의 개수
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			N[i] = Integer.parseInt(st.nextToken());
			sum += N[i];
		}
		K = Integer.parseInt(br.readLine());
		
		//(n1Ck + n2Ck)/(n1+n2)Ck 은 k!을 공통으로 같고 있으므로
		double ans = 0.0;
		for(int i=0; i<M; i++) {
			if(N[i] >= K) {
				prob[i] = 1.0;
				for(int k=0; k<K; k++) {
					prob[i] *= (double)(N[i]-k)/(sum-k);
				}
			}
			ans += prob[i];
		}
		//
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
		
	}


}
