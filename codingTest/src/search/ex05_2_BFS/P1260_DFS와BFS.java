package search.ex05_2_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_DFS와BFS {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1]; //정점이 1번부터 N번까지 (0은 무시)
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}
		
		//방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		for(int i=0; i<N+1; i++) {
			Collections.sort(arr[i]);
		}
		
		visited = new boolean[N+1];
		DFS(V);
		System.out.println();
		
		visited = new boolean[N+1];
		BFS(V);
		System.out.println();
		
	}

	private static void DFS(int node) {
		System.out.print(node + " ");
		
		visited[node] = true;
		for(int i : arr[node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
		
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int now_node = queue.poll();
			System.out.print(now_node + " ");
			for(int i : arr[now_node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
