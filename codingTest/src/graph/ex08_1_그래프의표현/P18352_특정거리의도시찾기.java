package graph.ex08_1_그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//왜틀린지 모르겟다
public class P18352_특정거리의도시찾기 {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static int count;
	static List<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //도시의 개수
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		int K = Integer.parseInt(st.nextToken()); //거리 정보
		int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호
		
		visited = new boolean[N+1];
		arr = new ArrayList[N+1];
		count = K;
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
		}
		
		BFS(X);
		if(result.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(result);
			for(int i : result) System.out.println(i);
		}
		
	}

	private static void BFS(int x) throws IOException {
		result = new ArrayList<>();
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visited[x] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int new_node = queue.poll();
			cnt++;
			for(int i : arr[new_node]) {
				if(!visited[i]) {
					visited[i]=true;
					if(cnt == count) result.add(i);
					queue.add(i);
				}
			}
		}
	}

}
