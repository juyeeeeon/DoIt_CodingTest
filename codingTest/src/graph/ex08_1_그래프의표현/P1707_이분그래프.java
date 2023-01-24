package graph.ex08_1_그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분그래프 {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static int[] group; //이분그래프는 두 개의 집합이 필요(그룹 0, 그룹 1). 각 정점들은 둘 중 하나
	static boolean isCycle; //cycle이 존재하면 이분 그래프가 아님.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		
		//K번의 테스트케이스
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			visited = new boolean[V+1];
			arr = new ArrayList[V+1];
			group = new int[V+1];
			isCycle = false;
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = new ArrayList<Integer>();
			}
			
			for(int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arr[s].add(e);
				arr[e].add(s);
			}
			
			group[1] = 0;
			
			//중요중요!
			
			//이어지지않은 두개의 그래프가 존재할 수 있음 
			//ex) 1-2 3-4-5
			//따라서 모든 정점에 대해 DFS을 돌림
			for(int j=1; j<=V; j++) {
				if(!isCycle) DFS(j);
				else break; //cycle이 존재하면 이미 이분그래프가 아님
			}
			
			if(isCycle) System.out.println("NO");
			else System.out.println("YES");
			
		}
	}

	private static void DFS(int node) {
		visited[node] = true;
		for(int i : arr[node]) {
			if(!visited[i]) {
				group[i] = (group[node]+1)%2; //전의 노드와 다른 집합에 속하기 위해 (0 또는 1)
				DFS(i);
			}else if(group[node] == group[i]) { //전의 노드와 지금 노드가 같은 집합에 속하면 cycle이 존재 >> 이분그래프 아님
				isCycle = true;
				return;
			}
		}
	}

}
