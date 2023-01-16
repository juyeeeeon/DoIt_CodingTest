package graph.ex08_1_그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DFS로 풀었을 때는 시간초과
 */
public class P1325_효율적인해킹 {
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static int[] result; //result[i]는 i번 째에 result[i]개가 연결되어 있다는 뜻 
	/*
	static int count;
	static int max;
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		result = new int[N+1];
		arr = new ArrayList[N+1];
		for(int i=0; i<arr.length; i++) arr[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
		}
		
		for(int i =1; i<arr.length; i++) {
			visited = new boolean[N+1];
			BFS(i);
		}
		
		int maxVal=0;
		for(int i=1; i<=N; i++) {
			maxVal = Math.max(maxVal, result[i]);
		}
		
		for(int i=1; i<=N; i++) {
			if(result[i] == maxVal) System.out.print(i+" ");
		}
		
		/*
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			arr[s].add(e);
		}
		
		
		for(int i=1; i<=N; i++) {
			count = 0;
			visited = new boolean[N+1];
			DFS(i);
			result[i] = count;
		}
		
		for(int i=1; i<N+1; i++) {
			if(result[i] == max) System.out.print(i+" ");
		}
		*/
	}
/*
	private static void DFS(int node) {
		visited[node] = true;
		count++;
		for(int i : arr[node]) {
			if(!visited[i]) DFS(i);
		}
		if(count>max) max = count;
	}
*/

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			int new_node = queue.poll();
			for(int i : arr[new_node]) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
					result[i]++;
				}
			}
		}
	}
}
