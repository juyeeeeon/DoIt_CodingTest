package dataStructure.ex03_5_스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P11286_절댓값힙 {
	//우선순위큐 이용하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>(new ComparatorImpl());
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input != 0) que.add(input);
			else {
				if(que.isEmpty()) System.out.println(0);
				else System.out.println(que.poll());
			}
		}
	}
	public static class ComparatorImpl implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) < Math.abs(o2)) return -1;
			else if(Math.abs(o1) > Math.abs(o2)) return 1;
			else return o1 <= o2 ? -1 : 1; //절대값이 같을 때 작은 수가 우선
		}

	}
}
