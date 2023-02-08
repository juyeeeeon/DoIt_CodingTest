package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2342_DanceDanceRevolution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int[][][] dp = new int[100001][5][5]; //[N개의 수열][왼쪽][오른쪽]
	
		//초기화
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				for(int k=0; k<100001; k++) {
					dp[k][i][j] = Integer.MAX_VALUE/2+1;
				}
			}
		}
		dp[0][0][0] = 0;
		
		
		int s = 1;
		while(true) {
			int input = Integer.parseInt(st.nextToken());
			if(input == 0) break; //입력이 0이면 종료
			
			//오른발(input)
			for(int i=0; i<5; i++) {
				if(input == i) continue; //두 발이 시작을 제외하고 같은 자리에 있을 수 없음
				for(int j=0; j<5; j++) {
					//오른발(j)을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장
					dp[s][i][input] = Math.min(dp[s-1][i][j] + move(j, input), dp[s][i][input]);
				}
			}
			
			//왼발(input)
			for(int j=0; j<5; j++) {
				if(input == j) continue;//두 발이 시작을 제외하고 같은 자리에 있을 수 없음
				for(int i=0; i<5; i++) {
					//왼발(i)을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장
					dp[s][input][j] = Math.min(dp[s-1][i][j] + move(i, input), dp[s][input][j]);
				}
			}
			s++;
		}
		
		s--;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				min = Math.min(min, dp[s][i][j]);
			}
		}

		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int move(int from, int to) {
		if(from == 0) return 2;
		else if(from == to) return 1;
		else if(Math.abs(from-to) == 1 || Math.abs(from-to) == 3) return 3;
		else return 4;
	}

}
