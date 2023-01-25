package graph.ex08_2_유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717_집합의표현 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		//대표노드를 자기 자신으로 초기화 하기
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(question == 0) {
				union(a,b);
			}else if(question == 1) {
				if(isSame(a,b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}

	//두 원소가 같은 집합에 속하는지
	private static boolean isSame(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return true;
		else return false;
	}
	
	//바로 연결이 아닌 대표 노드끼리 연결
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) parent[b] = a;
	}

	private static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]); //재귀함수 형태로 구현
		//			********* 이부분이 키포인트 : 자신을 호출한 재귀함수로 돌아가면서 값을 update
	}
}
