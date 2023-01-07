package search.ex05_1_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023_ABCDE {
	//문제 설명이 너무 적어...
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static boolean arrive  = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n];
		visited = new boolean[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}
		
		for(int i=0; i<n; i++) {
			DFS(i,1);
			if(arrive) break;
		}
		
		if(arrive) System.out.println("1");
		else System.out.println("0"); // 5의 깊이가 없다면 0 출력
	}

	private static void DFS(int now, int depth) {
		if(depth==5 || arrive) {
			arrive = true;
			return;
		}
		
		visited[now] = true;
		for(int i : arr[now]) {
			if(!visited[i]) {
				DFS(i,depth+1);
			}
		}
		
		visited[now] = false; //다른 경로가 존재할수도 있기 때문에 true에서 false로
	}
}
