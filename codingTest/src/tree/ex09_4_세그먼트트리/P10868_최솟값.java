package tree.ex09_4_세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868_최솟값 {
	static int k;
	static long minVal;
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		k = 0;
		while(Math.pow(2, k)<N) k++;
		
		tree = new long[(int) Math.pow(2, k+1)];
		
		for(int i=0; i<N; i++) {
			tree[(int) (Math.pow(2, k)+i)] = Long.parseLong(br.readLine());
		}
		
		for(int i=tree.length-1; i>1; i-=2) {
			tree[i/2] = Math.min(tree[i], tree[i-1]);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			System.out.println(findMin(a,b));
		}
	}

	private static long findMin(long a, long b) {
		int start = (int) (Math.pow(2, k)+a-1);
		int end = (int) (Math.pow(2, k)+b-1);
		
		minVal = Long.MAX_VALUE;
		while(start <= end) {
			
			if(start%2 == 1) //오른쪽노드
				minVal = Math.min(minVal, tree[start]);
			if(end%2 == 0) //왼쪽노드
				minVal = Math.min(minVal, tree[end]);
			
			start = (start+1)/2;
			end = (end-1)/2;
		}
		
		return minVal;
	}

}
