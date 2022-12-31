package dataStructure.ex03_2_구간합;

import java.util.Scanner;

public class P2018_수들의합5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		/* 내가 푼 것
		 * 배열이 0부터 시작으로 가정 [0/1/2/.../N]
		long count = 0;
		long sum = 1;
		long start_ptr = 0;
		long end_ptr = 1;
		
		while(true) {
			if(start_ptr == end_ptr) {
				sum = start_ptr;
				sum += ++end_ptr;
			}
			if(sum > N) sum -= start_ptr++;
			if(sum < N) sum += ++end_ptr;
			if(sum == N) {
				count++;
				if(end_ptr == N) break;
				sum += ++end_ptr;
			}
		}*/
		
		//배열이 1부터 시작으로 가정 [1/2/.../N]
		long count = 1;
		long sum = 1;
		long start_ptr = 1;
		int end_ptr = 1;
		
		while(end_ptr != N) {
			if(sum < N) {
				end_ptr++;
				sum += end_ptr;
			}else if(sum > N) {
                sum -= start_ptr;
				start_ptr++;
			}else {
				count++;
				end_ptr++;
				sum += end_ptr;
			}
		}
		
		System.out.println(count);
	}

}
