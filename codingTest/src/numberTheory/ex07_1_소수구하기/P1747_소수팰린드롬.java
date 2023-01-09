package numberTheory.ex07_1_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1747_소수팰린드롬 {
	//팰린드롬은 투포인터 이용하면 쉽게 찾을 수 있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//소수구하기 -> 에라토스테네스의 체 활용
		int[] arr = new int[10000001];
		for(int i=2; i<arr.length; i++) arr[i] = i;
		
		for(int i=2; i<=Math.sqrt(arr.length); i++) {
			if(arr[i]==0) continue;
			for(int j=i+i; j<arr.length; j+=i) {
				arr[j]=0;
			}
		}
		
		for(int i=N; i<arr.length; i++) {
			if(arr[i]!=0) {
				int result = arr[i];
				if(isPalindrom(result)) {
					System.out.println(result);
					break;
				}
			}
		}
	}

	private static boolean isPalindrom(int target) { //팰린드롬 구하기 -> 투포인터 활용
		char[] temp = String.valueOf(target).toCharArray();
		int s = 0;
		int e = temp.length - 1;
		while(s<e) {
			if(temp[s] != temp[e]) return false;
			s++;
			e--;
		}
		return true;
	}
}
