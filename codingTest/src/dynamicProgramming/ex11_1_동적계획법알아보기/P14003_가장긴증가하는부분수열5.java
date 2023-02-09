package dynamicProgramming.ex11_1_동적계획법알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14003_가장긴증가하는부분수열5 {
	static int N, maxLength;
	static int[] input, B, order;
	static ArrayList<Integer> ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		B = new int[N+1]; //증가하는 부분수열 저장, 부분 수열 중에 최댓값이 뭔지 알기 위해서?
		order = new int[N+1]; //input에 해당하는 자리에 크기 순서 저장
		ans = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int index;
		B[++maxLength] = input[1];
		order[1] = 1; //input의 1번째 값은 1번 순서이다.
		
		for(int i=2; i<=N; i++) {
			//가장 마지막 수열보다 현재 수열이 큰 경우
			if(B[maxLength] < input[i]) {
				B[++maxLength] = input[i];
				order[i] = maxLength;
			}else {
				// B배열에서 data[i]보다 처음으로 크거나 같아지는 원소의 index 찾기
				index = binarySearch(1, maxLength, input[i]);
				B[index] = input[i];
				order[i] = index;
			}
		}
		//가장 긴 증가하는 부분 수열 길이 출력
		System.out.println(maxLength);
		
		int x = B[maxLength] + 1;
		
		//뒤에서 부터 탐색하면서 정답 수열 저장하기
		for(int i=N; i>=1; i--) {
			if(order[i] == maxLength && input[i] <x) {
				ans.add(input[i]);
				x = input[i];
				maxLength--;
			}
		}
		for(int i=ans.size()-1; i>=0; i--) {
			bw.write(String.valueOf(ans.get(i)) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	// 현재 수열이 들어 갈 수 있는 위치를 빠르게 찾아주기 위한 바이너리 서치 구현
	private static int binarySearch(int l, int r, int now) {
		int mid;
		while(l < r) {
			mid = (l+r)/2;
			if(B[mid] < now) l = mid+1;
			else r = mid;
		}
		return l;
	}

}
