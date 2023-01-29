package graph.ex08_4_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1854_K번째최단경로찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //도시들의 개수
		int m = Integer.parseInt(st.nextToken()); //도시 간에 존재하는 도로의 수
		int k = Integer.parseInt(st.nextToken()); //k번째 최단경로 구하기
		
		ArrayList<Node>[] arr = new ArrayList[n+1];
		// k번째의 최단경로를 저장하기위해서는 각 dp에 사이즈가 최대 k인 최대 힙을 입혀 최단경로를 계속해서 갱신. 
		Queue<Integer>[] dis = new PriorityQueue[n+1]; 
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
			dis[i] = new PriorityQueue<Integer>(Collections.reverseOrder()); //최대힙(내림차순) : 큰 값이 front로
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			arr[s].add(new Node(e, t));
		}
		
		//boolean[] visited = new boolean[n+1];
		/*
		 * Queue<Integer>[] dis로 대체
		int[] time = new int[n+1];
		for(int i=0; i<time.length; i++) {
			time[i] = Integer.MAX_VALUE;
		}
		*/
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1, 0));
		//time[1] = 0;
		dis[1].add(0);
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			/*
			 * k번째 경로를 찾을때 까지 탐색해야하므로 방문여부 체크 x
			if(visited[now.city]) continue;
			else visited[now.city] = true;
			*/
			for(Node next : arr[now.city]) {
				/*
				if(time[next.city] > time[now.city] + next.time) {
					time[next.city] = time[now.city] + next.time;
					queue.add(new Node(next.city, time[next.city]));
				}
				*/
				
				//k개의 최단 경로 저장
				if(dis[next.city].size() < k) {
					dis[next.city].add(now.time + next.time);
				}
				//dis[next.city].size == k이고
				//k번째 최단경로(dis[next.city].peek())보다 현재 경로(now.time + next.time)가 더 작으면 최단 경로 갱신
				else if(dis[next.city].peek() > now.time + next.time) {
					dis[next.city].poll();
					dis[next.city].add(now.time + next.time);
				}

				queue.add(new Node(next.city, now.time + next.time));
			}
		}
		
		for(int i=1; i<dis.length; i++) {
			if(dis[i].size() == k) System.out.println(dis[i].peek());
			else System.out.println(-1);
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int city;
		int time;
		
		public Node(int city, int time) {
			this.city = city;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}
}
