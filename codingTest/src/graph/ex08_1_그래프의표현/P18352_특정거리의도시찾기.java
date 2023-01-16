package graph.ex08_1_그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352_특정거리의도시찾기 {
	static int[] visited; //visited을 boolean이 아닌 int로 표현 시 K(거리정보)을 나타낼 수 있음
	static ArrayList<Integer>[] arr;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		K = Integer.parseInt(st.nextToken()); //거리 정보
		int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호
		
		visited = new int[N+1];
		for(int i=0; i<visited.length; i++) {
			visited[i] = -1;
		}
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
		}
		
		BFS(X);

		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i<visited.length; i++) {
			if(visited[i] == K) result.add(i);
		}
		if(result.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(result);
			for(int i:result) {
				System.out.println(i);
			}
		}
		
		
		
	}

	private static void BFS(int x) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visited[x]++;
		
		while(!queue.isEmpty()) {
			int new_node = queue.poll();
			for(int i : arr[new_node]) {
				if(visited[i]==-1) {
					visited[i] = visited[new_node]+1;
					queue.add(i);
				}
			}
		}
	}

}
