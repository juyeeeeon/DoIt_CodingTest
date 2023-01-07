package search.ex05_2_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1167_트리의지름 {
	//어렵다아ㅏㅏ
	static ArrayList<Edge>[] arr;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[V+1];	//정점 번호는 1부터 V까지
		for(int i=0; i<V+1; i++) {
			arr[i] = new ArrayList<>();
		}

		for(int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			String node = st.nextToken();
			String item = st.nextToken();
			while(!item.equals("-1")) {
				arr[Integer.parseInt(node)].add(new Edge(Integer.parseInt(item), Integer.parseInt(st.nextToken())));
				item = st.nextToken();
			}
		}
		
		/*
		 * 1. 트리에서 임의의 정점 x를 잡는다.
		 * 2. 정점 x에서 가장 먼 정점 y를 찾는다.
		 * 3. 정점 y에서 가장 먼 정점 z를 찾는다.
		 * 트리의 지름은 정점 y와 정점 z를 연결하는 경로다.
		 * 
		 * 즉, 임의의 한 점에서 DFS나 BFS 알고리즘을 이용하여 각 노드까지의 거리를 구하고, 
		 * 이 중 최대 거리를 갖는 노드에서 시작하여 다시 한번 각 노드까지의 최대 거리를 구한다면 
		 * 그 최대 거리가 트리의 지름이 된다.
		 */
		distance = new int[V+1];
		visited = new boolean[V+1];
		BFS(1);
		int max = 1;
		for(int i=2; i<V+1; i++) {
			if(distance[max]<distance[i]) {
				max=i;
			}
		}
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[V]);
	}
	
	private static void BFS(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visited[vertex] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(Edge i : arr[now]) {
				if(!visited[i.vertex]) {
					visited[i.vertex] = true;
					queue.add(i.vertex);
					distance[i.vertex] = distance[now] + i.value;
				}
			}
		}
	}

	static class Edge{
		int vertex;
		int value;
		
		public Edge(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}
		
	}

}
