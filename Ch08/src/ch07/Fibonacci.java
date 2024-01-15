package ch07;

public class Fibonacci {

	int[] value;
	int number;
	
	public Fibonacci(int number) {
		this.number = number;
		value = new int[number];
	}
	
	//1. 재귀 함수로 풀이
	public int fibonacciRecur(int n) {
		

		if (n == 0) return 0;
		if (n == 1) return 1;

		//값을 함수로 호출하는 형태이다.
		return fibonacciRecur(n - 1) + fibonacciRecur(n - 2);
	}
	
	//2. 반복문으로 풀이
	public int fibonacciIter(int n) {
		
		int ppre = 0;	//전전 값
		int pre = 1;	//전 값
		int current = 0;

		if (n == 0) return 0;
		if (n == 1) return 1;

		for (int i = 2; i <= n; i++) {
			
			current = ppre + pre;
			ppre = pre;
			pre = current;	
		}

		return current;
	}
	
	//3. 메모이제이션, value배열에 넣는 방법
	public int fibonacciMem(int n) {
		
		value[0] = 0;
		value[1] = 1;
		int result = 0;
		
		if (n == 0) {
			return value[0];
		}
			
		if (n == 1) {
			return value[1];
		}
		
		for(int i = 2; i<=n; i++) {
			
			result = value[i-1] + value[i-2];
			
			if(value[i] == 0) {
				value[i] = result;
			}

		}
		
		return result;
	}
	
	//실행코드
	public static void main(String[] args) {

		//배열 수를 잡기 위해 100을 넣었다.
		Fibonacci fib = new Fibonacci(100);
		
		int result = fib.fibonacciRecur(10);
		System.out.println(result);
		
		result = fib.fibonacciIter(10);
		System.out.println(result);
		
		result = fib.fibonacciMem(10);
		System.out.println(result);
	}

}