package ch02;
import java.util.Scanner;

public class BinarySearchProblem { // 이진탐색, Binary Search

	public static void main(String[] args) {
		int[] numbers = { 12, 25, 31, 48, 54, 66, 70, 83, 95, 108 };

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int target = sc.nextInt();		
		System.out.println(target);
//		int target = 12;

		int left = 0; // left 위치는 첫번째
		int right = numbers.length - 1; // right 위치는 맨 마지막, 즉 9
		int mid = (left + right) / 2;	// 가운데부터 찾음. 즉 4

		int temp = numbers[mid]; // 비교할 내용은 해당 배열의 값, 중간부터 search, 즉 54
		boolean find = false;

		while (left <= right) {

			if (target == temp) {
				find = true;
				break;			//while문 빠져나감
			}
			
			else if (target < temp) {
				right = mid -1;
			}
			
			else  {
				left = mid +1;
			}
			
			//바뀐 값 다시 조정
			mid = (left + right) / 2;	
			temp = numbers[mid];
			System.out.println(target + "의 위치는 " + (mid+1) + "입니다.");
		}

		if (find == false) {
			System.out.println(target + "의 위치는 없습니다.");
		}
		
	}

}
