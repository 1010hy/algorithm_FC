[최단거리 구하기 문제]  
![image](https://github.com/1010hy/algorithm/assets/67892327/c8197978-92ce-489b-89f9-7abf6fbf6833)  

[문제 풀이]  
모든 노드 중 연결된 최단거리를 가진 노드를 찾아서  
노드 v에 인접한 노드 w 에 대해 다음 조건이 성립하면 w 에 대한 최단 거리를 업데이트 한다.  
(즉 원래 w로 가던 거리보다 v를 거쳐 가는 거리가 더 가까우면 w로 가는 거리는 v를 거쳐가는 것으로 최단 거리를 수정)  
Yw = Yv + Cvw if Yv + Cvw < Yw   
  
  
[출력 결과]   
![image](https://github.com/1010hy/algorithm/assets/67892327/b97f6e62-6a9e-4645-b4a8-d9fa8c1398af)
