package graph.ex08_3_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948_임계경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<dNode>[] arr = new ArrayList[n+1];
		ArrayList<dNode>[] reverseArr = new ArrayList[n+1];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
			reverseArr[i] = new ArrayList<>();
		}

		int[] inDegree = new int[n+1];
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			arr[s].add(new dNode(e, t));
			reverseArr[e].add(new dNode(s, t));
			inDegree[e]++;
		}
		
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		//위상정렬
		int[] result = new int[n+1];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startCity);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(dNode next : arr[now]) {
				inDegree[next.targetNode]--;
				result[next.targetNode] = Math.max(result[next.targetNode], result[now]+next.value);
				if(inDegree[next.targetNode] == 0)
					queue.add(next.targetNode);
			}
		}
		
		//위상정렬 reverse
		int resultCount = 0;
		boolean[] visited = new boolean[n+1];
		queue = new LinkedList<>();
		queue.add(endCity);
		visited[endCity] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(dNode next : reverseArr[now]) {
				//도착도시부터 시작하여 거꾸로 탐색하면서 각 도시까지의 최대비용과 비교해보면서
				//최대비용이 나오기 위해서 어떤 길들을 거쳐 도착도시에 도착했는지 알 수 있음.
				if(result[next.targetNode] + next.value == result[now]) { //1분도 쉬지 않는 도로 체크
					resultCount++;
					if(visited[next.targetNode] == false) {
						visited[next.targetNode] = true;
						queue.add(next.targetNode);
					}
				}
			}
		}
		
		System.out.println(result[endCity]);
		System.out.println(resultCount);
		
		
	}
	
	static class dNode{
		int targetNode;
		int value;
		
		public dNode(int targetNode, int value) {
			this.targetNode = targetNode;
			this.value = value;
		}
		
	}

}
