package graph.ex08_5_벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_타임머신 {
	static int N, M;
	static Edge[] arr; //엣지리스트
	static long[] distance; //int[]는 출력초과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //도시의 개수
		M = Integer.parseInt(st.nextToken()); //버스 노선의 개수
		
		arr = new Edge[M];
		
		distance = new long[N+1];
		/*
		for(int i=0; i<distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}*/
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			arr[i] = new Edge(A, B, C);
		}
		
		//벨만포드
		distance[1] = 0; //1번 도시에서 출발
		
		for(int i=0; i<N-1; i++) { //최단 거리 리스트에서 업데이트 반복 횟수는 "노드개수(N) - 1" 이다.
			for(int j=0; j<M; j++) {
				Edge edge = arr[j];
				//더 작은 최단거리가 있는 경우 갱신
				if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
					distance[edge.end] = distance[edge.start] + edge.time;
				}
			}
		}
		
		//음수 사이클 확인
		boolean mCycle = false;
		//모든 엣지를 한번씩 다시 사용해(N번째) 업데이트가 되는 노드가 발생하는지 확인
		for(int i=0; i<M; i++) {
			Edge edge = arr[i];
			if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
				mCycle = true;
			}
		}
		
		if(!mCycle) { //음수 사이클이 없는 경우
			for(int i=2; i<distance.length; i++) {
				if(distance[i] == Integer.MAX_VALUE) 
					System.out.println(-1);
				else 
					System.out.println(distance[i]);
			}
		}else { //음수 사이클이 있는 경우
			System.out.println(-1);
		}
		
	}
	
	static class Edge{
		int start;
		int end;
		int time;
		
		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
		
		
	}

}
