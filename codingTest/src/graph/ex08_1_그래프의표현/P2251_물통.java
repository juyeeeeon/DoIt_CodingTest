package graph.ex08_1_그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2251_물통 {
	static int[] sender = {0,0,1,1,2,2}; //물통A:0, 물통B:1, 물통C:2
	static int[] receiver = {1,2,0,2,0,1};
	static boolean[][] visited; //A와 B의 무게만 있으면 C의 무게를 알 수 있으므로
	static boolean[] answer; //idx가 C의 물의 양
	static int[] capacity; //A B C 의 용량
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		capacity = new int[3]; //A, B, C 물의 양을 저장하는 배열
		capacity[0] = Integer.parseInt(st.nextToken());
		capacity[1] = Integer.parseInt(st.nextToken());
		capacity[2] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[201][201];
		answer = new boolean[201];
		
		BFS(new AB(0,0)); //처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다.
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]) System.out.print(i+" "); //i가 C의 물의 양
		}
	}
	private static void BFS(AB ab) {
		Queue<AB> queue = new LinkedList<>();
		queue.add(ab);
		visited[ab.getA()][ab.getB()] = true;
		answer[capacity[2]] = true; //물통C
		
		while(!queue.isEmpty()) {
			AB p = queue.poll();
			int A = p.getA();
			int B = p.getB();
			int C = capacity[2] - A - B;
			
			for(int i=0; i<6; i++) { //A->B A->C B->A B->C C->A C->B : 총 6가지
				int[] next = {A,B,C};
				next[receiver[i]] = next[receiver[i]] + next[sender[i]]; //sender[i] -> receiver[i]
				next[sender[i]] = 0;
				if(next[receiver[i]] > capacity[receiver[i]]) { //대상 물통의 용량보다 물이 많아 넘칠 때
					next[sender[i]] = next[receiver[i]] - capacity[receiver[i]]; //초과하는 만큼 다시 이전 물통에 넣어줌
					next[receiver[i]] = capacity[receiver[i]]; //대상 물통은 최대로 채워줌
				}
				if(!visited[next[0]][next[1]]) { //next[0] : A의 물의 양, next[1] : B의 물의 양
					visited[next[0]][next[1]] = true;
					queue.add(new AB(next[0],next[1]));
					if(next[0] == 0) {
						answer[next[2]] = true;
					}
				}
			}
		}
		
	}
	
	private static class AB{
		private int A; //물통A의 물의 양
		private int B; //물통B의 물의 양

		public AB(int A, int B) {
			this.A = A;
			this.B = B;
		}

		public int getA() {
			return A;
		}

		public int getB() {
			return B;
		}
		
		
	}
}
