package geometry.ex12_1_기하알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P17387_선분교차2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		long[] x = new long[5];
		long[] y = new long[5];
		
		for(int i=1; i<=3; i+=2) {
			st = new StringTokenizer(br.readLine());
			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
			x[i+1] = Long.parseLong(st.nextToken());
			y[i+1] = Long.parseLong(st.nextToken());
		}
		
		boolean cross = isCross(x[1], y[1], x[2], y[2], x[3], y[3], x[4], y[4]);
		if(cross) bw.write(String.valueOf(1));
		else bw.write(String.valueOf(0));
		
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
		int abc = ccw(x1,y1,x2,y2,x3,y3);
		int abd = ccw(x1,y1,x2,y2,x4,y4);
		int cda = ccw(x3,y3,x4,y4,x1,y1);
		int cdb = ccw(x3,y3,x4,y4,x2,y2);
		
		if(abc*abd == 0 && cda*cdb == 0) //한 직선 위에 있을 때
			return isOverlap(x1, y1, x2, y2, x3, y3, x4, y4); 
		else if(abc*abd <= 0 && cda*cdb <= 0) //두 선분이 교차 할 때
			return true;
		else  //두 선분이 교차하지 않을 때
			return false;
	}
	
	//한 직선 위에 있을 때
	private static boolean isOverlap(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
		/* 내가 한 방식
		if(x1==x2 && x2==x3 && x3==x4) { //같은 x축 위에 존재할 때
			if(Math.min(y1, y2) >= Math.min(y3, y4) && Math.min(y1, y2) <= Math.max(y3, y4) ||
					Math.max(y1, y2) >= Math.min(y3, y4) && Math.max(y1, y2) <= Math.max(y3, y4)) {
				return true;
			}else return false;
		}
		else if(y1==y2 && y2==y3 && y3==y4) { //같은 y축 위에 존재할 때
			if(Math.min(x1, x2) >= Math.min(x3, x4) && Math.min(x1, x2) <= Math.max(x3, x4) ||
					Math.max(x1, x2) >= Math.min(x3, x4) && Math.max(x1, x2) <= Math.max(x3, x4)) {
				return true;
			}else return false;
		}
		// 한 선분의 양 끝 점 중 하나가 다른 선분 위에 존재할 때와 선분34가 선분12에 포함 될 때
		else if((Math.min(x3, x4)>=Math.min(x1, x2) && Math.min(x3, x4)<=Math.max(x1, x2)) || 
				(Math.max(x3, x4)>=Math.min(x1, x2) && Math.max(x3, x4)<=Math.max(x1, x2))) return true;
		
		// 한 선분의 양 끝 점 중 하나가 다른 선분 위에 존재할 때와 선분12가 선분34에 포함 될 때
		else if((Math.min(x1, x2)>=Math.min(x3, x4) && Math.min(x1, x2)<=Math.max(x3, x4)) || 
				(Math.max(x1, x2)>=Math.min(x3, x4) && Math.max(x1, x2)<=Math.max(x3, x4))) return true;
		else return false;
		*/
		
		//결국 간단하게 만들면 이거임 한 선분의 왼쪽(오른쪽)끝을 다른 선분의 오른쪽(왼쪽)을 이을 때 X자가 만들어지면 겹치는 거임.
		if(Math.min(x1, x2)<=Math.max(x3, x4) && Math.max(x1, x2)>=Math.min(x3, x4) &&
				Math.min(y1, y2)<=Math.max(y3, y4) && Math.max(y1, y2)>=Math.min(y3, y4)) return true;
		else return false;
	}

	private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long tmp = (x1*y2+x2*y3+x3*y1) - (x2*y1+x3*y2+x1*y3);
		if(tmp > 0) return 1;
		else if(tmp < 0) return -1;
		else return 0;
	}
	

}
