package dataStructure.ex03_4_슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input S, P
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int result= 0;
		
		//DNA 문자열 input
		st = new StringTokenizer(br.readLine());
		char[] arr = st.nextToken().toCharArray();
				
		//A - 0
		//C - 1
		//G - 2
		//T - 3
		
		//부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
		st = new StringTokenizer(br.readLine());
		int[] check = new int[4];
		for(int k=0; k<4; k++) {
			check[k] = Integer.parseInt(st.nextToken());
		}
		
		int i=0; 
		int j=i+P-1;
		
		boolean findResult = true;
		
		
		for(int q=i; q<=j; q++) {
			addCount(arr[q]);
		}
		
		
		while(j<S) {
			
			//부분문자열이 조건을 만족하는지 확인
			for(int q=0; q<check.length; q++) {
				if(count[q]<check[q]) {
					findResult = false;
					break;
				}
			}
			if (findResult) result++; //부분문자열이 조건을 만족함
			else findResult = true;	//부분문자열이 조건을 만족하지 않음
			//
			
			
			//부분문자열 한칸 오른쪽으로 이동
			switch(arr[i]){
				case 'A': count[0]--;
					break;
				case 'C': count[1]--;
					break;
				case 'G': count[2]--;
					break;
				case 'T': count[3]--;
					break;
			}
			
			i++;
			j=i+P-1;
			if(j>=S) break;
			
			addCount(arr[j]);
			
		}
		
		System.out.println(result);
		
	}
	
	private static int[] count = new int[4]; //부분문자열의 ACGT 갯수
	
	private static void addCount(char c) {
		switch(c) {
			case 'A': count[0]++;
				break;
			case 'C': count[1]++;
				break;
			case 'G': count[2]++;
				break;
			case 'T': count[3]++;
				break;
		}
	}

}
