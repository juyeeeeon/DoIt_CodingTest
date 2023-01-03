package sorting.ex04_5_병합정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1517_버블소트_2_시간초과 {
//시간초과
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int n = Integer.parseInt(st.nextToken());
		 
		 int[] arr = new int[n];
		 st = new StringTokenizer(br.readLine());
		 for(int i=0; i<n; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 buff = new int[n];
		 __mergeSort(arr,0,n-1);
		 
		 br.close();
		 bw.write(String.valueOf(num)); //buffer에 write할 때 integer는 안됌.(string으로 변환 필요)
		 bw.flush();
		 bw.close();
		 
		 
	}
	private static int[] buff;
	private static int num=0;

	private static void __mergeSort(int[] arr, int left, int right) {
		if(left<right) {
			int center = (left+right)/2;
			
			__mergeSort(arr,0,center);
			__mergeSort(arr,center+1,right);
			int i;
			int j=left;
			int k = left;
			for(i=left; i<=center; i++) buff[i] = arr[i];
			int p = i;
			
			while(i<=right && j<p) {
				if(buff[j]<=arr[i]) {
					arr[k++]=buff[j++];
					num++;
				}else {
					arr[k++]=arr[i++];
					//num++;
				}
			}
			while(j<p) {
				arr[k++] = buff[j++];
				num++;
			}
		}
	}

}
