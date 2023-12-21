package ch03;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 80, 50, 70, 10, 60, 20, 40, 30 };

		int i = 0;
		int j = 0;
		int temp = 0;
		int count = arr.length;

		for (i = 1; i < count; i++) {	//만약 i가 2이면 {50, 80, 70, 10, 60, 20, 40, 30} 상태
			temp = arr[i]; // 70
			j = i;			// 2
			
			//j가 앞으로 한칸씩 가며 비교
			while ((j > 0) && arr[j - 1] > temp) { // arr[1]>arr[2] 즉 80>70 이면
				arr[j] = arr[j - 1]; // arr[2]에 arr[1]값 넣고 즉, 70위치에 80 넣고
				j = j - 1;			//j는 1이 되어 다시 while문 실행
			}
			arr[j] = temp;		//while 끝나면(비교 끝나면) arr[j]에 arr[i] 값 넣음.
		}
		System.out.println(Arrays.toString(arr));
	}
}
