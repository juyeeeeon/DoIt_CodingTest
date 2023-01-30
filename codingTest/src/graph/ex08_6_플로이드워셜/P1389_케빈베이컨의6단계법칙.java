package graph.ex08_6_플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //유저의 수
		int M = Integer.parseInt(st.nextToken()); //친구관계의 수
		
		int[][] arr = new int[N+1][N+1];
		
		//입력의 친구관계의 가중치를 1로 가정하면
		//한 노드에서 다른 노드의 관계 수를 알 수 있음
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				if(i == j) arr[i][j] = 0;
				else arr[i][j] = Integer.MAX_VALUE/2 -1;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		for(int k=1; k<arr.length; k++) {
			for(int i=1; i<arr.length; i++) {
				for(int j=1; j<arr.length; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		int[] result = new int[N+1];
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				result[i] += arr[i][j];
			}
		}
		
		int tmp = result[1];
		int asw = 1;
		for(int i=2; i<arr.length; i++) {
			if(tmp>result[i]) {
				asw = i;
				tmp = result[i];
			}
		}
		System.out.println(asw);
		
		
	}

}
