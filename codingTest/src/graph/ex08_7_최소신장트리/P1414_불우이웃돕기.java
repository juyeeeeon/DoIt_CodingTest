package graph.ex08_7_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1414_불우이웃돕기 {
	
	static int N; //컴퓨터의 개수
	static PriorityQueue<Edge> queue;
	static int[] parent;
	static int allLength; //총 랜선의 길이
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queue = new PriorityQueue<>();
		allLength = 0;
		
		for(int i=1; i<=N; i++) {
			char[] tmp = new char[N];
			tmp = br.readLine().toCharArray(); //tmp[]에 idx0부터 저장됨.
			for(int j=1; j<=N; j++) {
				if(tmp[j-1] == '0') continue; //tmp[]의 값은 char임(int가 아님!)
				else{
					allLength += toLength(tmp[j-1]);
					queue.add(new Edge(i, j, toLength(tmp[j-1])));
				}
			}
		}
		
		//union-find
		//대표노드를 자기 자신으로 초기화
		parent = new int[N+1];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		int numEdge = 0;
		
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			if(find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				result += edge.weight;
				numEdge++;
			}
		}
		
		if(numEdge == N-1) System.out.println(allLength - result);
		else System.out.println(-1); //모든 컴퓨터가 연결x
		
		
	}
	
	private static void union(int start, int end) {
		start = find(start);
		end = find(end);
		
		parent[end] = start;
	}

	private static int find(int i) {
		if(parent[i] == i) return i;
		
		return parent[i] = find(parent[i]);
	}

	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) { //오름차순
			return this.weight - o.weight;
		}
		
	}
	
	static int toLength(char a) {
		if(Character.isLowerCase(a))
			return (a-'0') - 48; //소문자
		else 
			return (a-'0') + 10; //대문자
	}

}
