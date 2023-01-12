package numberTheory.ex07_3_유클리드호제법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1033_칵테일 { //너무너무너무너무너무너무 어렵다
/*
 * ex>  비율은 "a b p q"와 같은 형식이고, 
 * 		a번 재료의 질량을 b번 재료의 질량으로 나눈 값이 p/q라는 뜻
 * 			 a b p q
 * 	input << 2 3 6 8
	2의 질량 = 3의질량*2의질량*6
	3의 질량 = 2의질량*3의질량*8
	
	2의질량/3의질량 = 6/8
	8*(2의질량) = 6*(3의질량)
	
		   a의질량 = (p/q) * (b의질량)
		>> 2의질량 = (6/8) * (3의질량)
	
		   b의질량 = (q/p) * (a의질량)
		>> 3의질량 = (8/6) * (2의질량)
		
	>>>> 첫 재료의 질량을 기준으로 잡고 
		 이를 기준으로 비율에 맞게 업데이트 시킴
*/	
	
	static ArrayList<cNode>[] A;
	static long lcm; //최소공배수(LCM = Least Common Multiple)
	static boolean[] visited; //방문노드확인 for DFS
	static long D[]; //각 재료의 질량을 담는 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		//칵테일을 만드는 재료의 개수
		int N = Integer.parseInt(br.readLine()); 
		
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		
		lcm = 1; //최소공배수 초기화(=1)
		
		for(int i=0; i<N; i++) A[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			A[a].add(new cNode(b,p,q));
			A[b].add(new cNode(a,q,p));
			
			//최소공배수 = 두 수의 곱/최대공약수
			lcm = lcm * (p*q/gcd(p,q)); 
			
			/*  
			 *  0,1의 최소공배수
			 * 	1,2의 최소공배수
			 * 	2,3의 최소공배수
			 * 	...
			 * 	모두 곱 => lcm
			 * 	>>> lcm = 각 재료의 비율들의 최소공배수들의 곱
			 */
		}
		
		/*
		 * 첫 재료의 질량(lcm)을 기준으로 잡고 
		 * 이를 기준으로 비율에 맞게 업데이트 시킴
		 */
		D[0] = lcm;
		DFS(0);
		
		long mgcd = D[0];
		for(int i=1; i<N; i++) {
			mgcd = gcd(mgcd,D[i]); //각 재료의 질량의 최대공약수를 구하기
		}
		
		for(int i=0; i<N; i++) {
			bw.write(D[i]/mgcd+ " "); //각 재료의 질량(각 비율의 X배 값)/ 모든 재료 질량 값의 최대공약수(X값) = 최소공배수
		}
		
		bw.flush();
		bw.close();
		
	}
	
	private static void DFS(int a) {
		visited[a] = true;
		for(cNode i : A[a]) {
			int b = i.getB();
			if(!visited[b]) {
				//각 재료의 질량을 담는 배열인 D에 0번 째 재료의 질량을 기준으로 
				//다른 재료의 질량을 비율에 맞게 배열에 담기
				D[b] = D[a] * i.getQ()/i.getP();
				DFS(b);
			}
		}
		
}
	
	//최대공약수 구하기
	//유클리드 호제법 활용
	private static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b,a%b);
}

	static class cNode{
		int b;
		int p;
		int q;
		
		public cNode(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}

		public int getB() {
			return b;
		}

		public int getP() {
			return p;
		}

		public int getQ() {
			return q;
		}
	}
}
