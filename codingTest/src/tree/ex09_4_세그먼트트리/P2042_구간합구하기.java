package tree.ex09_4_세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_구간합구하기 { //int로 하면 런타임에러떠서 long으로 바꾸니 됨
	static long N, M, K;
	static long[] tree;
	static long k, sumResult;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		////////////////////////////////////////////////////////////////////////////////
		//1) 트리 초기화하기
		
		//1-1) 2^k >= N 을 만족하는 k의 최솟값을 구한 후, 
		k = 0;
		while(Math.pow(2, k) < N){
			k++;
		}
		
		//1-2) 2^k * 2 를 트리 배열의 크기로 정의한다.
		tree = new long[(int) (Math.pow(2, k+1))];
		
		//1-3) 2^k 를 시작 인덱스로 취하여 리프 노드에 원본 데이터를 입력한다.
		for(int i=0; i<N; i++) {
			int idx = (int) Math.pow(2, k)+i;
			tree[idx] = Long.parseLong(br.readLine());
		}
		
		//1-4) 리프 노드를 제외한 나머지 노드의 값을 채운다.
		//(2^k -1 부터 1번쪽으로 채움)
		for(int i=tree.length-1; i>2; i-=2) {
			tree[i/2] = tree[i]+tree[i-1];
		}
		////////////////////////////////////////////////////////////////////////////////
		
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				change(b, c);
			}
			else {
				sum(b, c);
				System.out.println(sumResult);
			}
		}
	}
	
	private static void sum(long b, long c) { //b번째 수부터 c번째 수까지의 합
		sumResult = 0;

		//세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경.
		//* 세그먼트 트리 index = 주어진 질의 index + 2^k - 1
		int start_idx = (int) (Math.pow(2, k) + b - 1);
		int end_idx = (int) (Math.pow(2, k) + c - 1);
		
		//2-5) 2-1)~2-4)를 반복하다가 start_index > end_index 가 되면 종료한다.
		while(start_idx <= end_idx) {
			//2-1) start_index % 2 == 1 일 때 해당 노드를 선택한다.
			if(start_idx % 2 == 1) { //오른쪽 노드
				sumResult += tree[start_idx];
			}
			//2-2) end_index % 2 == 0 일 때 해당 노드를 선택한다.
			if(end_idx % 2 == 0) { //왼쪽 노드
				sumResult += tree[end_idx];
			}
			//2-3) start_index depth 변경 : start_index = (start_index + 1) / 2 연산을 실행
			//2-4) end_index depth 변경 : end_index = (end_index - 1) / 2 연산을 실행
			start_idx = (start_idx + 1)/2;
			end_idx = (end_idx - 1)/2;
		}
	}
	
	private static void change(long b, long c) { //b번째 수를 c로 바꿈
		//세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경.
		//* 세그먼트 트리 index = 주어진 질의 index + 2^k - 1
		int idx = (int) (Math.pow(2, k) + b - 1);
		
		//(변경 후의 값 - 변경 전의 값)을 현재 idx부터 idx = idx/2를 반복하여 root노드까지 업데이트
		long diff = c - tree[idx];
		
		while(idx > 0) {
			tree[idx] = tree[idx] + diff;
			idx /= 2;
		}
	}

}
