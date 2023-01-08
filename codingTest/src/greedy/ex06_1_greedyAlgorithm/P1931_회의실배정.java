package greedy.ex06_1_greedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Time[] arr = new Time[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		
		int count=0;
		int end = -1;
		for(int i=0; i<N; i++) {
			if(arr[i].start >= end) {
				end = arr[i].end;
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	static class Time implements Comparable<Time>{
		int start;
		int end;
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			if(this.end == o.end) return this.start - o.start; //종료시간이 같으면 시작시간 순으로
			else return this.end - o.end; //종료시간 순으로
		}
	}
}
