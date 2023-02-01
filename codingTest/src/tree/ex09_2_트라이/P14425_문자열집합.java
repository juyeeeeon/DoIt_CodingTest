package tree.ex09_2_트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14425_문자열집합 {
	static int N, M;
	static String[] S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//트라이 알고리즘
		tNode root = new tNode();
		
		while(N > 0) { //트라이 자료구조 구축하기
			String text = br.readLine();
			tNode now = root;
			for(int i=0; i<text.length(); i++) {
				char c = text.charAt(i);
				
				if(now.next[c-'a']==null)//해당 문자가 비어있으면 노드 추가
					now.next[c-'a'] = new tNode();
				
				now = now.next[c-'a']; //다음 노드로 업데이트
				if(i==text.length()-1) //문자열 끝이면
					now.isEnd = true; //마크
			}
			N--;
		}
		
		int count = 0;
		while(M>0) {//트라이 자료구조 검색하기
			String text = br.readLine();
			tNode now = root;
			
			for(int i=0; i<text.length(); i++) {
				char c = text.charAt(i);
				if(now.next[c-'a'] == null) 
					break; //해당 문자열을 포함하지 않음
				
				now = now.next[c-'a'];
				if(i==text.length()-1 && now.isEnd) 
					count++; //문자열의 끝이고 현재까지 모두 일치
			}
			M--;
		}
		
		System.out.println(count);
		
		
		/* 내가 푼 방식
		S = new String[N];
		for(int i=0; i<N; i++) {
			S[i] = br.readLine();
		}
		int result = 0;
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			for(int j=0; j<S.length; j++) {
				if(S[j].equals(tmp)) result++;
			}
		}
		
		System.out.println(result);
		*/
	}
	
	//for trie algorithm
	static class tNode{
		tNode[] next = new tNode[26];
		boolean isEnd; //문자열의 마지막 유무를 표시
	}

}
