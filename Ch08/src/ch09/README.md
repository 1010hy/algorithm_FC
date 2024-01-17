[경우의 수 문제 (Brute-Force Search)]  

1. 경우의 수
   - 모든 경우에 대하여 탐색하여 결과를 찾는 문제
   - 문제의 범위가 간단한 경우 완전 탐색으로 모든 해를 찾아보는 방식
   - 수학에서 수열이나 조합과 같은 문제를 해결하는데 사용
   - 문제의 set이 너무 많고 경우의 수가 많으면 이 방법으로 찾을 수 없다.
   - 그래서 범위가 한정적일 때만 쓸 수 있다.
   - 간단한(무식한) 방법으로 for문을 돌리는 것이다.
   - for문이 늘어날 수록 n의 제곱수가 늘어나기 때문에 좋은 알고리즘은 아니다.

2. 문제 정의  
   심각한 인플레이션을 겪고 있는 어느나라에서 1만원, 2만원, 5만원, 10만원 20만원 50만원 여섯가지 지폐를 사용하고 있다.  
   배고파씨는 100만원 어치 빵을 사려고 마트에 가서 돈을 내려다 여섯 가지 지폐를 이용하여 100만원 어치 빵을 사는 방법이 모두 몇 가지인지 궁금해 졌다.  
   지불하는 방법은 모두 몇 가지가 있을까?  
   예를 들어 1만원 10장, 10만원 4장, 50만원 1장 으로 100만원을 지불 할 수 있다.  
   모두 몇가지인지 구하세요.  

3. 문제 해결  
   100 만원이 되는 모든 경우에 대해 탐색하여 지불 가능한 경우의 수를 세어본다.

4. 참고 사항  
   피보나치수열의 코드처럼 recursive로 구현할 수 있다. 그러면 코드는 더 깔끔해진다. 하지만 효율은 똑같이 좋지 않다.

5. 출력 결과  
   ![image](https://github.com/1010hy/algorithm/assets/67892327/867a6448-d971-4acd-ab96-e64709e6b218)
