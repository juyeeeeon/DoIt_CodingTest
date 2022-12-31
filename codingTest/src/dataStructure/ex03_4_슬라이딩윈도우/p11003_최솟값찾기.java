package dataStructure.ex03_4_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p11003_최솟값찾기 {
	
	public static class Node {
		public int value;
		public int index;
			
		Node(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//어렵당 이걸 어떻게 생각하지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			/*
			 *  새로운 값이 들어 올 때마다 정렬하지 않고 
			 *  현재 수보다 큰 값을 덱에서 제거함으로써 시간복잡도를 줄일 수 있음
			 */
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now,i));
			// 범위에서 벗어난 값은 덱에서 제거
			if(mydeque.getFirst().index <= i-L) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value+" ");
		}
		
		bw.flush();
		bw.close();
		
		
		/* 내가 한 것 (시간초과)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//input N , L
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		//input 숫자열
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N+1; i++) {
			if((i-L+1) <= 0) continue;
			int st_ptr=i-L+1;
			int la_ptr=i;
			int minVal = arr[st_ptr];
			while(st_ptr<=la_ptr) {
				if(arr[st_ptr] < minVal) minVal = arr[st_ptr];
				st_ptr++;
			}
			System.out.println(minVal);
		}
		 */
	}

}
