package graph.ex08_5_벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1219_오민식의고민 {

	static int N, start, end, M;
	static Edge[] edges;
	static long[] distance, cityMoney;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //도시의 수
		start = Integer.parseInt(st.nextToken()); //시작도시
		end = Integer.parseInt(st.nextToken()); //도착도시
		M = Integer.parseInt(st.nextToken()); //교통수단의 개수
		
		edges = new Edge[M];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(s, e, c);
		}
		
		st = new StringTokenizer(br.readLine());
		cityMoney = new long[N];
		for(int i=0; i<cityMoney.length; i++) {
			cityMoney[i] = Long.parseLong(st.nextToken());
		}
		
		distance = new long[N];
		Arrays.fill(distance, Long.MIN_VALUE);
		
		
		//변형된 벨만포드
		distance[start] = cityMoney[start];
		
		for(int i=0; i<N+100; i++) { //양수 사이클이 전파되도록 충분히 큰 수로 반복
			for(int j=0; j<M; j++) {
				Edge edge = edges[j];
				
				if(distance[edge.start] == Long.MIN_VALUE) continue; //시작노드가 미방문 노드면 스킵
				//시작 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 갱신
				else if(distance[edge.start] == Long.MAX_VALUE) distance[edge.end] = Long.MAX_VALUE;
				else if(distance[edge.end] < distance[edge.start] - edge.cost + cityMoney[edge.end]) {
					distance[edge.end] = distance[edge.start] - edge.cost + cityMoney[edge.end];
					// N-1 반복 이후 갱신되는 종료 노드는 양수사이클 연결 노드로 변경
					if(i >= N-1) distance[edge.end] = Long.MAX_VALUE;
				}
			}
		}
		
		if(distance[end] == Long.MIN_VALUE) System.out.println("gg");// 도착 불가능
		else if(distance[end] == Long.MAX_VALUE) System.out.println("Gee");// 양수사이클 연결
		else System.out.println(distance[end]);
	}
	
	static class Edge{
		int start, end, cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

}
