package dataStructure.ex03_5_스택과큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1874_스택수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int num = 1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			
			if(now >= num) {
				while(now >= num) {
					stack.push(num);
					sb.append("+\n");
					num++;
				}
				stack.pop();
				sb.append("-\n");
				
			}else if(now < num) {
				if(stack.pop() > now) {
					System.out.println("NO");
					return;
				}else sb.append("-\n");
			}
		}
		
		System.out.println(sb);
	}

}
