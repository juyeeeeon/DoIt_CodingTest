package tree.ex09_1_트리알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기 {
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		tree = new ArrayList[N+1];
		result = new int[N+1];
		
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
		
		DFS(1);
		
		for(int i=2; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	private static void DFS(int i) {
		visited[i] = true;
		
		for(int j : tree[i]) {
			if(!visited[j]) {
				result[j] = i;
				DFS(j);
			}
		}
	}

}
