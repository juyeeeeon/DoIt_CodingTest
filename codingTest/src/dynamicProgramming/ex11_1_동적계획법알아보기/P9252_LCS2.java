package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9252_LCS2 {
//https://www.youtube.com/watch?v=z8KVLz9BFIo 참고
	static char[] A;
	static char[] B;
	static long[][] dp;
	static ArrayList<Character> path;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		
		dp = new long[A.length + 1][B.length + 1];
		path = new ArrayList<>();
		
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[A.length][B.length]);
		getText(A.length, B.length);
		for(int i=path.size()-1; i>=0; i--) {
			System.out.print(path.get(i));
		}
		System.out.println();
	}

private static void getText(int a, int b) {
	if(a==0 || b==0) return;
	if(A[a-1] == B[b-1]) {
		path.add(A[a-1]);
		getText(a-1, b-1);
	}else {
		if(dp[a-1][b] > dp[a][b-1])
			getText(a-1, b);
		else
			getText(a, b-1);
	}
}

}
