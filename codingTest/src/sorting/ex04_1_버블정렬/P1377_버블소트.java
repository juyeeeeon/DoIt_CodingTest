package sorting.ex04_1_버블정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377_버블소트 {
	/*
	 * 아이디어 생각하는게 어렵다.
	 * 버블정렬은 O(n^2)이므로 시간초과
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	    int N = Integer.parseInt(reader.readLine());
	    mData[] A = new mData[N];
	    
	    for (int i = 0; i < N; i++) {
	      A[i] = new mData(Integer.parseInt(reader.readLine()), i); //정렬 전 숫자와 인덱스를 저장
	    }
	    
	    Arrays.sort(A);//A배열 정렬 O(nlogn)시간 복잡도
	    
	    int Max = 0;
	    /*
	     * kEY IDEA! : 배열의 한 element가 배열 앞쪽으로 얼마나 이동했는지
	     * 				한 번의 루프마다 element는 앞쪽으로 한 번씩 밖에 이동하지 못하므로
	     */
	    for (int i = 0; i < N; i++) {
	      if (Max < A[i].index - i) //정렬 전 index - 정렬 후 index 계산 값의 최대 값을 찾아 저장
	        Max = A[i].index - i;
	    }
	    
	    System.out.println(Max + 1);
	 }
}

class mData implements Comparable<mData> {
	  int value;
	  int index;

	  public mData(int value, int index) {
	    this.value = value;
	    this.index = index;
	  }

	  @Override
	  public int compareTo(mData o) {//value 기준 오름차순 정렬
	    return this.value - o.value;
	  }
}