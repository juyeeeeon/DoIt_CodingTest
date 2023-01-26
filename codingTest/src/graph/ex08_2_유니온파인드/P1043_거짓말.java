package graph.ex08_2_유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1043_거짓말 {
	static int[] parent;
	static int[] trueP;
	static int result;
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //사람의 수
		int M = Integer.parseInt(st.nextToken()); //파티의 수
		
		//대표노드를 자기 자신으로 초기화
		parent = new int[N+1];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); //진실을 아는 사람의 수
		trueP = new int[T]; //진실을 아는 사람 저장
		for(int i=0; i<trueP.length; i++) {
			trueP[i]=Integer.parseInt(st.nextToken());
		}
		
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int party_size = Integer.parseInt(st.nextToken());
			for(int j=0; j<party_size; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//각 파티에 참여한 사람들을 하나의 그룹으로 만들기
		for(int i=0; i<M; i++) {
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		for(int i=0; i<M; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0; j<trueP.length; j++) {
				if(find(cur) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) result++;
		}
		System.out.println(result);
	}

	private static int find(int i) {
		if(i == parent[i]) return i;
		
		return parent[i] = find(parent[i]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) parent[b] = a;
	}

}
