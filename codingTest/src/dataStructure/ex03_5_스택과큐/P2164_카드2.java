package dataStructure.ex03_5_스택과큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드2 {
	//이거는 쉬웠다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<>(); //Queue사용
		for(int i=1; i<=N; i++) {
			que.add(i);
		}
		
		while(que.size()>1) {
			que.poll();
			que.add(que.poll());
		}
		
		System.out.print(que.peek());
	}

}
