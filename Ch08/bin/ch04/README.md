[DFS(Depth - First Search)와 BFS(Breadth - First Search)]

그래프탐색  

![image](https://github.com/1010hy/algorithm/assets/67892327/de538611-0cdf-4de4-b6eb-f0825f725352)

동그라미가 노드, 선이 간선


[2차원 배열로 표현하는 법]  
![image](https://github.com/1010hy/algorithm/assets/67892327/9d1b35db-9072-4cbe-a163-623e1928beb7)
1. 언다이랙트 그래프(방향성이 없음)
연결되면 1, 연결이 안돼있으면 0으로 표시, 언다이랙트 그래프는 시멘틱함.(대각선을 기준으로 동일)  

2. 다이랙트 그래프(방향성이 있음)  
시멘틱하지 않음.(대각선을 기준으로 동일하지 않음)  

3. weight 그래프  
단순 0, 1이 아닌 숫자로 가중치를 표시  


   
<링크드 리스트>  
0 -> 1 -> 2 -> ...  
*weight가 있으면 하나의 클래스로 옆에 가중치까지 표시 가능  
![image](https://github.com/1010hy/algorithm/assets/67892327/bee987ea-2e70-42ac-a265-10cc163871eb)


<DFS 깊이 우선 탐색>  
갈림길을 만나면 한쪽으로 감  
stack으로 구현  
*traverse : 찾아다닌다  
*방문한 것은 표시  
0 - 1 - 3 - 7 - 4 - 5 - 2 - 6 (왼쪽으로 돎)  
0 - 2 - 6 - 5 - 4 - 1 - 3 - 7 (오른쪽으로 돎)  

DfsSearch.java 출력결과  
![image](https://github.com/1010hy/algorithm/assets/67892327/2b6697c7-0696-4b92-ba93-c0c8cfd8c15c)

 
<BFS 너비 우선 탐색>  
갈림길을 만나면 양쪽을 다 봄  
queue로 구현  
0 - 1 - 2 - 3 - 4 - 5 - 6 - 7  

3,4는 1의 입장에서  
5,6은 2의 입장에서  
7은 3의 입장에서 들어감.  

BfsSearch.java 출력결과  
![image](https://github.com/1010hy/algorithm/assets/67892327/fdff229c-0a8f-4e91-9c38-17af51180adb)


<stack 스텍>  
후입선출
   
1. 0을 넣음 

2. (바깥에 있는) 0을 꺼냄
3. 0에 인접한 1,2를 넣음
4. 바깥에 있는 2를 꺼냄
5. 2에 인접한 5,6을 넣음
6. 바깥에 있는 6을 꺼냄
7. 6에 인접한게 없으므로 바깥에 있는 5를 꺼냄
8. 5에 인접한 4를 넣음    
. . .

즉 스텍에 가장 마지막에 넣은걸 빼면서 그것에 인접한 + 방문하지 않은 것을 넣음.  



<queue 큐>  
선입선출
