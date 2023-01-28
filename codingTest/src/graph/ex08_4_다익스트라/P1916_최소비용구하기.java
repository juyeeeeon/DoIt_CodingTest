package graph.ex08_4_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //도시의 개수
		int M = Integer.parseInt(br.readLine()); //버스의 개수	
		
		ArrayList<Node>[] arr = new ArrayList[N+1];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 1) 인접 리스트로 그래프 구현하기
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[s].add(new Node(e,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		//다익스트라
		
		// 2) 최단 거리 배열 초기화하기 : 출발 노드는 0, 이외의 노드는 무한으로 초기화
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		for(int i=0; i<distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		
		// 3) 최단 거리 배열에서 값이 가장 작은 노드 고르기 (PriorityQueue 이용)
		PriorityQueue<Node> queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.add(new Node(start, 0));
		
		//4) 최단 거리 배열 업데이트하기 : 선택된 노드에 연결된 엣지의 값을 바탕으로 다른 노드의 값을 업데이트하기
		//5) 모든 노드가 처리될 때까지 3) ~ 4) 반복,
		//			4)에서 선택 노드가 될 때마다 다시 선택되지 않도록 방문 배열을 만들어 처리,
		//			모든 노드가 선택될 때까지 반복하면 최단 거리 배열이 완성
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			if(visited[current.city]) continue;
			else visited[current.city] = true;
			
			for(Node next : arr[current.city]) {
				if(distance[next.city] > distance[current.city] + next.cost) {
					distance[next.city] = distance[current.city] + next.cost;
					queue.add(new Node(next.city, distance[next.city]));
				}
			}
		}
		
		System.out.println(distance[end]);
		
	}
	
	static class Node implements Comparable<Node>{ //오름차순 : PriorityQueue에서 작은 수가 먼저 pop
		int city;
		int cost;
		
		public Node(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}
