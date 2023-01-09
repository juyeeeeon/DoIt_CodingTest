package numberTheory.ex07_1_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1456_거의소수 {
	//에라토스테네스의 체
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		/*
		 * 문제에서 A와 B의 범위는 <=10^14 인데 
		 * 소수의 N제곱(N>=2)꼴의 개수를 구하는 것이므로
		 * 10^7까지만 구하면 된다. (그 이상은 10^14 범위를 넘음)
		 */
		long[] arr = new long[10000001];
		for(int i=2; i<arr.length; i++) arr[i] = i;
		
		for(int i=2; i<=Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			for(int j=i+i; j<arr.length; j+=i) {
				arr[j] = 0;
			}
		}
		
		int count=0;
		for(int i=2; i<arr.length; i++) {
			if(arr[i] != 0) {
				long tmp = arr[i];
				/*
				 * 이해가 가장 안되었던 부분
				 * tmp*tmp <=(혹은 >=) B(혹은 A)는 overflow 발생
				 * 따라서 양변은 tmp로 나눔 -> 우항의 tmp는 매 반복마다 증가하므로 arr[i]로(위와 같은 식)
				 */
				while((double)tmp <= (double)B/(double)arr[i]) { 
					if((double)tmp >= (double)A/(double)arr[i]) { 
						count++;
					}
					tmp *= arr[i];
				}
			}
		}
		System.out.println(count);
	}

}
