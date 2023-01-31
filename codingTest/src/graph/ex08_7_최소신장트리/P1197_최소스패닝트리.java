package graph.ex08_7_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197_최소스패닝트리 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		//엣지리스트
		PriorityQueue<Edge> queue = new PriorityQueue<>(); //가중치(C)를 오름차순 정렬
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			queue.add(new Edge(a, b, c));
		}
		/*
		Edge[] edges = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}
		Arrays.sort(edges); //가중치(C)를 오름차순 정렬
		*/
		
		//유니온파인드리스트 초기화
		//대표노드를 자기 자신으로 초기화 하기
		parent = new int[V+1];
		for(int i=1; i<parent.length; i++) {
			parent[i] = i;
		}
		
		/////////////////////////////////////////
		int result = 0;
		int useEdge = 0;
		while(useEdge < V-1) { //최소신장트리의 엣지는 V-1 개이다.
			Edge edge = queue.poll();
			// 같은 부모가 아니라면 -> 연결해도 사이클이 생기지 않는다면
			if(find(edge.A) != find(edge.B)) {
				union(edge.A, edge.B);
				result += edge.C; //가중치 더하기
				useEdge++;
			}
		}
		
		System.out.println(result);
		
		
	}
	
	/////////////////////유니온파인드//////////////////////
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		parent[b] = a;
	}

	private static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	///////////////////////////////////////////////////////

	static class Edge implements Comparable<Edge>{
		int A, B, C;

		public Edge(int a, int b, int c) {
			A = a;
			B = b;
			C = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.C - o.C;
		}
		
	}
}
