package tree.ex09_5_최소공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11437_LCA { //일반적인 최소공통조상 구하기
	static int N, M;
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		for(int i=0; i<tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			tree[s].add(e);
			tree[e].add(s);
		}
		
		depth = new int[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		BFS(1);
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			System.out.println(LCA(node1, node2));
		}
		
	}

	private static int LCA(int node1, int node2) {
		if(depth[node1] < depth[node2]) { //더 깊은 depth가 node1이 되도록 변경
			int tmp = node1;
			node1 = node2;
			node2 = tmp;
		}
		while(depth[node1] != depth[node2]) { //두 노드의 depth 맞추기
			node1 = parent[node1];
		}
		while(node1 != node2) {
			node1 = parent[node1];
			node2 = parent[node2];
		}
		
		return node1;
	}

	private static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(i);
		visited[i] = true;
		
		depth[i] = 1;
		
		int level = 2;
		int now_size = queue.size();
		int count = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int next : tree[now]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
					parent[next] = now; //부모 노드 저장
					depth[next] = level; //노드의 depth 저장
				}
			}
			
			count++;
			if(count == now_size) {
				count = 0;
				now_size = queue.size();
				level++;
			}
		}
	}

}
