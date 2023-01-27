package graph.ex08_3_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2252_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); //키를 비교한 횟수
		/*
		 * 1) 그래프를 ArrayList로 표현(사이클이 없어야 함)
		 * 2) 진입 차수 배열을 업데이트
		 */
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int[] inDegree= new int[N+1]; //진입차수배열

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			arr[S].add(E);
			
			inDegree[E]++;
		}
		
		/*
		 * 3) 진입 차수 배열에서 진입 차수가 0인 노드를 선택하고, 선택된 노드를 정렬 배열(결과)에 저장
		 * 4) 인접 리스트에서 선택된 노드가 가리키는 노드들의 진입 차수를 1씩 뺌
		 * 5) 진입 차수 배열이 모두 0일 때 까지 3)~4) 반복
		 */
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<inDegree.length; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now+" ");
			
			for(int next : arr[now]) {
				inDegree[next]--;
				if(inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}

}
