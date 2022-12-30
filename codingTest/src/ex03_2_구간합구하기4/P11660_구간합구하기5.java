package ex03_2_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합구하기5 {
	//부분 합 구하기
    //D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for(int x=1; x<N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y=1; y<N; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		//이 부분이 어려웠음
		int[][] D = new int[N][N];
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + arr[i][j];
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
			
			
		}
		
		/* 내가 한 것 (시간초과)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		N+=1;
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for(int y=1; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=1; x<N; x++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			long sum = 0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1; j<=y2; j++) {
				for(int k=x1; k<=x2; k++) {
					sum += arr[k][j];
				}
			}
			
			System.out.println(sum);
			
		}
		*/
	}

}
