package greedy.ex06_1_greedyAlgorithm;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744_수묶기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> positive_pq = new PriorityQueue<>(Collections.reverseOrder()); //양수 내림차순 정렬
		PriorityQueue<Integer> negative_pq = new PriorityQueue<>(); //음수 오름차순 정렬
		
		// 0, 1, 1보다 큰 양수, 음수로 나눔
		int one = 0;
		int zero = 0;
		for(int i=0; i<N; i++) {
			int data = sc.nextInt();
			if(data > 1) positive_pq.add(data);
			else if(data == 1) one++;
			else if(data == 0) zero++;
			else negative_pq.add(data);
		}
		
		int sum = 0;
		
		while(positive_pq.size() > 1) {
			int data1 = positive_pq.poll();
			int data2 = positive_pq.poll();
			sum += data1 * data2;
		}
		//pq에 데이터가 1개 또는 0개 남음
		
		if(!positive_pq.isEmpty()) sum += positive_pq.poll(); //pq에 데이터가 1개가 남았을 때 
		
		while(negative_pq.size() > 1) {
			int data1 = negative_pq.poll();
			int data2 = negative_pq.poll();
			sum += data1 * data2;
		}
		//pq에 데이터가 1개 또는 0개 남음
		
		if(!negative_pq.isEmpty()) { //pq에 데이터가 1개가 남았을 때
			if(zero == 0) sum += negative_pq.poll(); //zero가 없다면 더하고
		}											//zero가 존재하면 곱하면 0이 되니까 의미 없음
		
		sum += one; //남은 1(one) 모두 더함
		System.out.println(sum);
	}
}
