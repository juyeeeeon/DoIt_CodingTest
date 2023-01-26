package graph.ex08_2_유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976_여행가자 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //도시의 수
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //여행 계획에 속한 도시들의 수
		
		//대표노드를 자기 자신으로 초기화
		parent = new int[N+1];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int[][] city = new int[N+1][N+1];
		for(int i=1; i<city.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<city[i].length; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] route = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<route.length; i++) {
			route[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<city.length; i++) {
			for(int j=1; j<city[i].length; j++) {
				if(city[i][j] == 1) union(i,j);
			}
		}
		
		int node = find(route[1]);
		for(int i=2; i<route.length; i++) {
			if(find(route[i]) != node) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	private static int find(int i) {
		if(i == parent[i]) return i;
		
		return parent[i] = find(parent[i]);
	}
	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i != j) parent[j] = i;
	}

}
