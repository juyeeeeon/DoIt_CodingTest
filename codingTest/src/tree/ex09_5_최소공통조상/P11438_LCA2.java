package tree.ex09_5_최소공통조상;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11438_LCA2 {
	static int N, M;
	static ArrayList<Integer>[] tree;
	static int[][] parent;
	static int[] depth;
	static int kMax;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//BufferedWroter 안쓰면 시간초과뜸
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		for(int i=0; i<tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			tree[s].add(e);
			tree[e].add(s);
		}
		
		depth = new int[N+1];
		visited = new boolean[N+1];

		kMax = 0;
		while(Math.pow(2, kMax) < N) kMax++; //최대가능 depth구하기
		
		parent = new int[kMax+1][N+1];
		
		BFS(1); //depth를 BFS를 통하여 구하기
		
		for(int k=1; k<kMax; k++) {
			for(int n=1; n<=N; n++) {
				parent[k][n] = parent[k-1][parent[k-1][n]];
			}
		}
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			bw.write(LCA(node1, node2)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(node);
		visited[node] = true;
		
		depth[node] = 1;
		int level = 2;
		int queueSize = 1;
		int count = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : tree[now]) {
				if(!visited[next]) {
					visited[next] = true;
					depth[next] = level;
					parent[0][next] = now; //노드 next의 2^0(=1)번째 부모노드 = now
					queue.add(next);
				}
			}
			count++;
			if(count == queueSize) {
				count = 0;
				queueSize = queue.size();
				level++;
			}
		}
				
	}

	private static int LCA(int node1, int node2) {
		if(depth[node1] > depth[node2]) { //node2의 depth가 더 깊게 변경
			int tmp = node1;
			node1 = node2;
			node2 = tmp;
		}
		
		for(int k=kMax; k>=0; k--) { //depth 빠르게 맞춰주기
			if(Math.pow(2, k) <= depth[node2] - depth[node1]) {
				if(depth[node1] <= depth[parent[k][node2]])
					node2 = parent[k][node2];
			}
		}
		
		for(int k=kMax; k>=0 && node1 != node2; k--) { //조상빠르게찾기
			if(parent[k][node1] != parent[k][node2]) {
				node1 = parent[k][node1];
				node2 = parent[k][node2];
			}
		}
		
		int result = node1;
		if(node1 != node2) result = parent[0][result];
		return result;
	}

}
