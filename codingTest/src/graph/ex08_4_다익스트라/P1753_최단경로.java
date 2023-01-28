package graph.ex08_4_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine()); //시작 정점의 번호
		
		ArrayList<Node>[] arr = new ArrayList[V+1];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[u].add(new Node(v, w));
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		for(int i=0; i<distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		queue.add(new Node(K, 0)); //K을 시작점으로
		distance[K] = 0;
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int curNode = current.node;
			
			if(visited[curNode]) continue;
			else visited[curNode] = true;
			
			for(int i=0; i<arr[curNode].size(); i++) {
				Node tmp = arr[curNode].get(i);
				int next = tmp.node;
				int value = tmp.value;
				if(distance[next] > distance[curNode] + value) {
					distance[next] = distance[curNode] + value;
					queue.add(new Node(next, distance[next]));
				}
			}
		}
		
		for(int i=1; i<distance.length; i++) {
			if(visited[i]) System.out.println(distance[i]);
			else System.out.println("INF");
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int node;
		int value;
		
		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) { //오름차순 : priority queue에서 작은 수가 front로
			if(this.value > o.value) return 1;
			else return -1;
		}
		
	}
}
