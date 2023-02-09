package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2098_외판원순회 {
	//이해가 안돼애ㅐㅐㅐ 
	static final int INF = Integer.MAX_VALUE/2 + 1;
	static int N;
	static int[][] W;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];  //[여기부터][여기까지의]비용
		
		// ex) 1 << 5 = 100000(2) = 32 -> 우리의 최대값 : 11111(2) 이므로 1 빼기
		dp = new int[N][(1<<N)-1]; 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(String.valueOf(tsp(0, 1)));
		bw.flush();
		bw.close();
		br.close();
	
	}

	private static int tsp(int city, int visitBitmask) {
		if(visitBitmask == (1<<N) - 1) { //모든 도시를 방문했다면
			return W[city][0] == 0 ? INF : W[city][0];
		}
		
		if(dp[city][visitBitmask] != 0) { //dp값이 존재하는 경우
			return dp[city][visitBitmask];
		}
		
		int min_val = INF;
		// 현재 도시(city)에서 각 i의 도시로 이동한 경우에 대해 tsp 수행
		for(int i=0; i<N; i++) {	
			// 한 번이라도 그 도시를 방문했는데 다시 그 도시를 방문하는 경우 예외처리
			if((visitBitmask & (1 << i)) == 0 && W[city][i] != 0) {	
				//d[i][j] = 현재 있는 도시가 i이고 이미 방문한 도시들의 집합이 j일때, 방문하지 않은 나머지 도시들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용.
				//즉, 방문해야하는 도시(여기에 시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용
				// tsp(다음 도시, 다음도시 방문했다고 가정) + 여기서 다음 도시까지의 거리 와 최소거리 비교
				min_val= Math.min(min_val, tsp(i, visitBitmask | (1 << i)) + W[city][i]);	
			}
		}
		dp[city][visitBitmask] = min_val;
		return dp[city][visitBitmask];
	}

}
