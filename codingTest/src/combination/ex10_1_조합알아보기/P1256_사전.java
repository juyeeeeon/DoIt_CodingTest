package combination.ex10_1_조합알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1256_사전 {
	//어렵다아ㅏㅏ
	static int[][] D; // aCb = a!/(a-b)!b! 즉, 가능한 케이스의 수
	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //a의 개수
		M = Integer.parseInt(st.nextToken()); //z의 개수
		K = Integer.parseInt(st.nextToken()); //K번째 문자열
		
		D = new int[201][201]; //[a+z의 개수][a의 개수 또는 z의 개수]
		
		for(int i=0; i<D.length; i++) {
			for(int j=0; j<= i; j++) {
				if(i == j || j == 0) D[i][j] = 1;
				else {
					D[i][j] = D[i-1][j] + D[i-1][j-1];
					// K 범위가 넘어가면 범위 최대 값 저장
					if(D[i][j] > 1000000000) D[i][j] = 1000000001;
				}
			}
		}
		
		//만들 수 있는 문자열의 개수가 K보다 작을 때
		if(D[N+M][M] < K) bw.write(String.valueOf(-1));
		else {
			while(N != 0 || M != 0) {
				//a를 선택하였을 때
				//남은 문자로 만들 수 있는 모든 경우의 수가 K보다 크면
				if(D[N-1+M][M] >= K) {
					bw.write("a");
					N--;
				}else { //K보다 작으면
					bw.write("z");
					K = K - D[N-1+M][M]; //a를 선택 했을 때의 경우의 수를 뺌 
					M--;
				}
			}
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}


}
