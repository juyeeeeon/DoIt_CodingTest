package numberTheory.ex07_1_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929_소수구하기 {
	/*
	 * 소수구하기의 핵심 이론 <에라토스테네스의 체>
	 * 1) 구하고자 하는 소수의 범위만큼 1차원 배열을 생성
	 * 2) 2부터 시작하고 현재 숫자가 지워지지 않을 때는 현재 선택된 숫자의 배수에 해당하는 수를
	 *    배열에서 끝까지 탐색하면서 지움. 이때 처음으로 선택된 숫자는 지우지 않음.
	 * 3) 배열의 끝까지 2)를 반복한 후 (N의 제곱근까지만 탐색) 배열에서 남아있는 모든 수를 출력.
	 * 
	 * N의 제곱근까지만 탐색하는 이유? N = root(N)*root(N)이므로
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		//에라토스테네스의 체 구현
		int[] arr = new int[N+1]; //1) 구하고자 하는 소수의 범위만큼 1차원 배열을 생성
		for(int i=2; i<arr.length; i++) arr[i] = i; //index0과 index1은 소수가 아니므로 지움(->0으로)
		
		//2) 2부터 시작하고 현재 숫자가 지워지지 않을 때는 현재 선택된 숫자의 배수에 해당하는 수를
		//   배열에서 끝까지 탐색하면서 지움(->0으로). 이때 처음으로 선택된 숫자는 지우지 않음.
		for(int i=2; i <= Math.sqrt(N); i++) {
			if(arr[i]==0)continue;
			for(int j= i+i; j<=N; j+=i) {
				arr[j] = 0;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(arr[i] != 0) System.out.println(arr[i]);
		}
	}

}
