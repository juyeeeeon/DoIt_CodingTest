package graph.ex08_3_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516_게임개발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=0; i<arr.length; i++) arr[i] = new ArrayList<>();
		
		int[] time = new int[N+1];	//자기 자신을 짓는데 걸리는 시간
		int[] inDegree = new int[N+1];	//진입차수배열
		
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == -1) continue;
			while(tmp != -1) {
				arr[tmp].add(i);
				inDegree[i]++;
				tmp = Integer.parseInt(st.nextToken());
			}
		}
		
		//위상정렬
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<inDegree.length; i++) {
			if(inDegree[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int next : arr[now]) {
				inDegree[next]--;
				result[next] = Math.max(result[next], result[now]+time[now]);
				//B -> A
				//C -> A
				//한 노드(A)에 여러 다른 노드(B, C, ...)가 가리킬 수 있음
				//result[now]+time[now] : A를 가르키는 C를 지은 것까지의 시간
				//result[next] : A를 가르키는 B를 지은 것 까지의 시간
				if(inDegree[next] == 0)
					queue.add(next);
			}
		}
		
		for(int i=1; i<result.length; i++) {
			System.out.println(result[i] + time[i]);
		}
	}

}
