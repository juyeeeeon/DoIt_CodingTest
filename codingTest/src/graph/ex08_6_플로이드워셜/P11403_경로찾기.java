package graph.ex08_6_플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403_경로찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				//if(i==j) arr[i][i]=0; else  //입력값(1/0)은 가중치가 아닌 연결여부를 나타내므로
				arr[i][j] = Integer.MAX_VALUE/2 -1;
			}
		}
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) arr[i][j] = 1; //i에서 j로 가중치가 1이라 가정하고 품
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == Integer.MAX_VALUE/2 -1) System.out.print(0 + " ");
				else System.out.print(1+" ");
			}
			System.out.println();
		}
	}
}
