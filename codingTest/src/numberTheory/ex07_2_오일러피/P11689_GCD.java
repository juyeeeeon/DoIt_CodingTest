package numberTheory.ex07_2_오일러피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11689_GCD {
	//어려워ㅓㅓㅓ
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long result = n;
		
		for(long i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) { //i가 소인수이면,
				result = result - result/i; //result와 서로소인 수의 개수를 구하는 공식
				while(n%i == 0) n/=i; //i값인 소인수를 나눠서 i을 없앰
			}
		}
		
		// 아직 소인수 구성이 남아있는 경우
		//(반복문에서 제곱근까지만 탐색했기 때문에 1개의 소인수가 누락되는 케이스)
		//ex) n=5일 때 5의 서로소는 1,2,3,4 (5는 아니므로)
		if(n>1) result = result - result/n;
		System.out.println(result);
		
	}
}
