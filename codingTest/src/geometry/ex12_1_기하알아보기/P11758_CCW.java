package geometry.ex12_1_기하알아보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11758_CCW {
	//https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-11758%EB%B2%88-CCW-Java-Python 참고
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int[] x = new int[4];
		int[] y = new int[4];
		
		for(int i=1; i<=3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		//기하학 기초 알고리즘 신발끈공식 CCW(Counter ClockWise)
		//신발끈 공식은 좌표평면 상에서 꼭짓점의 좌표를 알 때 다각형의 면적을 구할 수 있는 방법
		
		//반시계 <-> 양수
		//시계 <-> 음수
		//일직선 <-> 0
		int ccw = (x[1]*y[2] + x[2]*y[3] + x[3]*y[1]) - (x[2]*y[1] + x[3]*y[2] + x[1]*y[3]);
		if(ccw > 0) bw.write(String.valueOf(1)); //반시계방향
		else if(ccw == 0) bw.write(String.valueOf(0)); //일직선
		else bw.write(String.valueOf(-1)); //시계방향
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}