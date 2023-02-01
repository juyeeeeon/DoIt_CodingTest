package tree.ex09_3_이진트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {
	static int N;
	static int[][] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		tree = new int[26][2]; //0:왼쪽자식노드 1:오른쪽자식노드
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int node = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			//자식 노드가 없을 경우 -1을 저장
			if(left == '.') tree[node][0] = -1;
			else tree[node][0] = left - 'A';
			
			if(right == '.') tree[node][1] = -1;
			else tree[node][1] = right - 'A';
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
		
	}
	private static void preOrder(int now) {
		if(now == -1) return;
		System.out.print((char)(now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}
	
	private static void inOrder(int now) {
		if(now == -1) return;
		inOrder(tree[now][0]);
		System.out.print((char)(now+'A'));
		inOrder(tree[now][1]);
	}
	
	private static void postOrder(int now) {
		if(now == -1) return;
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		System.out.print((char)(now+'A'));
	}


}
