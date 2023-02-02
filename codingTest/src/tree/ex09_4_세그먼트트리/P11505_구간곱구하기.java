package tree.ex09_4_세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505_구간곱구하기 {
	static long N, M, K, k;
	static long[] tree;
	static long answer;
	static final long MOD = 1000000007; //오버플로우 발생하므로 모든 노드값에 MOD값을 나눔
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken()); //수의 개수
		M = Long.parseLong(st.nextToken()); //수의 변경이 일어나는 횟수
		K = Long.parseLong(st.nextToken()); //구간의 곱을 구하는 횟수
		
		k = 0;
		while(Math.pow(2, k) < N) k++;
		
		tree = new long[(int) Math.pow(2, k+1)];
		
		for(int i=0; i<tree.length; i++) { //초기값을 곱셈이기에 1로 설정
			tree[i] = 1;
		}
		
		for(int i=0; i<N; i++) {
			tree[(int) (Math.pow(2, k) + i)] = Long.parseLong(br.readLine());
		}
		
		for(int i=tree.length-1; i>1; i-=2) {
			tree[i/2] = tree[i]*tree[i-1]%MOD;
		}
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) chage(b, c);
			if(a == 2) System.out.println(mul(b, (int)c)%MOD);
		}
	}
	
	private static void chage(long b, long c) { //b번째 수를 c로 바꾸기
		int idx = (int) (Math.pow(2, k) + b - 1);

		tree[idx] = c;
		
		while(idx>1) {
			idx = idx/2;
			tree[idx] = tree[idx*2]%MOD * tree[idx*2+1]%MOD;
		}
				
	}

	private static long mul(long b, long c) { //b부터 c까지의 곱을 구하여 출력
		int start = (int) (Math.pow(2, k) + b - 1);
		int end = (int) (Math.pow(2, k) + c - 1);
		
		answer = 1;
		
		while(start <= end) {
			if(start % 2 == 1) answer = answer * tree[start] % MOD;
			if(end % 2 == 0) answer = answer * tree[end] % MOD;
			
			start = (start+1)/2;
			end = (end-1)/2;
		}
		
		return answer;
	}
}
