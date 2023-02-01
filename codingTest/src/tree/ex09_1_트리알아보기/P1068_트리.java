package tree.ex09_1_트리알아보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1068_트리 {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int root;
	static int result;
	static int delNum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		tree = new ArrayList[N];
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int s = Integer.parseInt(st.nextToken());
			if(s != -1) {
				tree[s].add(i);
				tree[i].add(s);
			}else{
				root = i;
			}
		}
		
		delNum = Integer.parseInt(br.readLine());

		if(delNum == root) System.out.println(0);
		else {
			DFS(root);
			System.out.println(result);
		}
	}
	
	private static void DFS(int root) {
		visited[root] = true;
		int cNode = 0;
		
		for(int i : tree[root]) {
			if(!visited[i] && i != delNum) {
				visited[i] = true;
				cNode++;
				DFS(i);
			}
		}
		
		if(cNode == 0) result++;
		
	}

}
