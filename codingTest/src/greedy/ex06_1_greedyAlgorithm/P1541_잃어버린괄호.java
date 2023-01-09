package greedy.ex06_1_greedyAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] b = a.split("-");
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=0; i<b.length; i++) {
			int sum=0;
			String[] split_plus = b[i].split("\\+"); //"+"는 에러 뜸
			for(int j=0; j<split_plus.length; j++) {
				sum+=Integer.parseInt(split_plus[j]);
			}
			queue.add(sum);
		}
		int result = queue.poll();
		while(!queue.isEmpty())	result -= queue.poll();
		
		System.out.println(result);
	}

}
