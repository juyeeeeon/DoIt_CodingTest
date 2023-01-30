package graph.ex08_6_플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404_플로이드 {
	static int n, m;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //도시의 개수
		m = Integer.parseInt(br.readLine()); //버스의 개수
		
		arr = new int[n+1][n+1];
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[i].length; j++) {
				if(i==j) arr[i][i]=0;
				else arr[i][j] = Integer.MAX_VALUE/2 -1; //Integer.MAX_VALUE는 오버플로우 발생
			}
		}
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(arr[s][e] > c) arr[s][e] = c; //s-e가 같지만 c가 다른 경우
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) { 				//밑에서 Integer.MAX_VALUE는 오버플로우 발생
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					/* 위와 같음
					 * if (distance[i][j] > distance[i][k] + distance[k][j])
            		   distance[i][j] = distance[i][k] + distance[k][j];
					 */
				}
			}
		}
		
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr[i].length; j++) {
				if(arr[i][j] == Integer.MAX_VALUE/2 -1) System.out.print(0+" ");
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
