package numberTheory.ex07_1_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1016_제곱ㄴㄴ수 {
	//제일 어렵고 이해안갔던 것
	//https://chanhuiseok.github.io/posts/baek-16/  참고
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		boolean[] check = new boolean[(int)(max-min+1)];// 최대 최소 차이만큼 배열 선언
		
		//제일 이해가 안갔던 부분
		// 2의 제곱수인 4부터 max보다 작거나 같은 까지 반복
		for(long i=2; i*i<=max; i++) {
			long start_index = min / (i*i);
			
			if(min % (i*i) != 0) start_index++;// 나머지가 있으면 1을 더해야 min보다 큰 제곱수부터 시작됨
			for(long j = start_index; (i*i)*j <= max; j++) {// 제곱수를 true로 변경
				check[(int)( (j*(i*i)) - min )] = true;
			}
		}
		
		int count =0;
		for(int i=0; i<= max-min; i++) {
			if(!check[i]) count++;
		}
		System.out.println(count);
	}

}
