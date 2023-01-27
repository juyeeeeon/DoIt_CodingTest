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
		
		int[] time = new int[N+1];
		int[] inDegree = new int[N+1];
		int result = 0;
		
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
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<inDegree.length; i++) {
			if(inDegree[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			result = 0;
			int now = queue.poll();
			result += time[now];
			System.out.println(result);
			for(int i : arr[now]) {
				inDegree[i]--;
				if(inDegree[i] == 0)
					queue.add(i);
			}
		}
	}

}
