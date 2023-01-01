package dataStructure.ex03_5_스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수 {

	public static void main(String[] args) throws IOException {
		//어려웡
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		int[] arr = new int[N];
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0); //스택 안에 arr의 idx를 넣음
		for(int i=1; i<N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i : ans) {
			bw.write(i + " ");
		}
		
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}
