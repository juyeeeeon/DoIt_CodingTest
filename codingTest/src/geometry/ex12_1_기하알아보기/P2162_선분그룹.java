package geometry.ex12_1_기하알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2162_선분그룹 {
//그룹의 갯수
//가장 큰 그룹의 선분의 갯수
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int[][] lines = new int[N+1][5]; //[1~N개의 선분][(x1,y2),(x3,y4)]
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i][1] = Integer.parseInt(st.nextToken()); //x1
			lines[i][2] = Integer.parseInt(st.nextToken()); //y2
			lines[i][3] = Integer.parseInt(st.nextToken()); //x3
			lines[i][4] = Integer.parseInt(st.nextToken()); //y4
			
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				
				int parent1 = find(i);
				int parent2 = find(j);
				if(parent1 != parent2) {
					if(isCross(lines[i][1], lines[i][2], lines[i][3], lines[i][4], lines[j][1], lines[j][2], lines[j][3], lines[j][4])) {
						Union(i, j);
					}
				}
			}
		}
		
		int[] cnt = new int[N+1];
		int size = 0;
		int max = 0;
		
		for(int i=1; i<=N; i++) {
			cnt[parent[i]]++;
		}
		
		for(int i=1; i<=N; i++)	{
			if(max < cnt[i]) max = cnt[i];
			if(cnt[i] != 0) size++;
		}
	
		bw.write(String.valueOf(size)+'\n'+String.valueOf(max)+'\n');
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void Union(int i, int j) {
		i = find(i);
		j = find(j);
		
		if(i != j) {
			parent[j] = i;
		}
	}

	private static int find(int i) {
		if(i == parent[i]) 
			return i;
		else 
			return parent[i] = find(parent[i]);
	}

	private static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int abc = ccw(x1,y1,x2,y2,x3,y3);
		int abd = ccw(x1,y1,x2,y2,x4,y4);
		int cda = ccw(x3,y3,x4,y4,x1,y1);
		int cdb = ccw(x3,y3,x4,y4,x2,y2);
		
		if(abc*abd == 0 && cda*cdb == 0) //한 직선 위에 있을 때
			return isOverlap(x1, y1, x2, y2, x3, y3, x4, y4);
		else if(abc*abd <= 0 && cda*cdb <= 0) // 두 선분이 교차
			return true;
		else 
			return false;
	}
	
	private static boolean isOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if(Math.min(x1, x2) <= Math.max(x3, x4) && Math.max(x1, x2) >= Math.min(x3, x4) &&
				Math.min(y1, y2) <= Math.max(y3, y4) && Math.max(y1, y2) >= Math.min(y3, y4))
			return true;
		else 
			return false;
	}
	private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		int tmp = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
		
		if(tmp > 0) 
			return 1;
		else if(tmp == 0) 
			return 0;
		else 
			return -1;
	}

}
