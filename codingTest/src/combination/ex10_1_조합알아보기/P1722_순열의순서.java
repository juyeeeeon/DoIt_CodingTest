package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1722_순열의순서 {
	//어려웡
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
	
		long[] F = new long[21];
		int[] S = new int[N];
		boolean[] visited = new boolean[21];
		
		F[0] = 1;
		for(int i=1; i<=N; i++	) { //각 자리수에서 만들 수 있는 경우의 수
			F[i] = F[i-1]*i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		
		if(Q == 1) {	//k번째 순열 구하기
			long k = Long.parseLong(st.nextToken());
			
			for(int i=0; i<N; i++) {
				for(int j=1; j<=N; j++) { // 1부터 N까지의 숫자
					if(visited[j]) continue; //이미 사용한 숫자는 사용할 수 없음
					
					//주어진 k에 따라 각 자리에 들어갈 수 있는 수 찾기
					if(F[N-i-1] < k) { //숫자 하나(=j)의 나머지 자리의 가짓수가 k보다 작으면 다음으로 큰 숫자로
						k -= F[N-i-1];
					}else {
						S[i] = j;
						visited[j] = true;
						break;
					}
				}
			}
			for(int i=0; i<N; i++) {
				bw.write(String.valueOf(S[i])+ " ");
			}
			
		}else { //N개의 수를 입력 -> 몇 번째 수열인지 출력
			for(int i=0; i<N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = 1; //순열은 1번째부터 시작
			for(int i=0; i<N; i++) {//i는 (i+1)번째 자릿수, 즉 각 자리수마다
				for(int j=1; j<S[i]; j++) { //j는 1부터 해당 자리의 값보다 작은 순의 경우의 수
					if(!visited[j]) ans+=F[N-i-1];
				}
				visited[S[i]] = true;
			}
			
			bw.write(String.valueOf(ans));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
