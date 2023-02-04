package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2775_부녀회장이될테야 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] apt = new int[15][15];
		for(int i=1; i<apt.length; i++) {
			apt[0][i] = i;
		}
		
		for(int i=1; i<apt.length; i++) {
			for(int j=1; j<apt[i].length; j++) {
				/*
				for(int k=1; k<=j; k++) {
					apt[i][j] += apt[i-1][k];
				}*/
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			bw.write(apt[k][n]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
