<정렬 알고리즘>

평균 수행 시간이 O(n^2)인 알고리즘
- 버블 정렬(Bubble Sort), 삽입 정렬(Insertion Sort), 선택 정렬(Selection Sort)
- 각 요소가 다른 요소와 평균 한번 이상씩 비교를 하여 정렬됨
- 선택 정렬은 n개를 살펴보는 게 n번이라 시간복잡도는 n^2
- 버블 정렬은 맨 앞부터 두 개씩만 비교하며 옆으로 이동. 시간복잡도는 n^2

Insertion Sort(삽입정렬) 구현해보기
- Insertion Sort의 기본 개념은 이미 정렬된 상태의 요소에 새로운 요소를 추가할 때 정렬하여 추가하는 개념이다.(손안의 카드)
- 두 번째 요소부터 바로 앞 요소와 비교하며 한칸씩 앞으로 이동. 그렇게 insert 될 위치를 찾아가며 정렬하는 알고리즘
- 이동횟수가 n번이고 이것이 n번 수행되기 때문에 시간복잡도는 n^2
![image](https://github.com/1010hy/algorithm/assets/67892327/97c636b7-6b38-4b18-afd5-bd712942321e)

결과
1) InsertionSort 출력 결과
   
![image](https://github.com/1010hy/algorithm/assets/67892327/15b10ebf-53b1-4b52-81df-bb64e854446e)

2) InsertionSortExample 출력 결과
   
![image](https://github.com/1010hy/algorithm/assets/67892327/a71d14e1-70db-46ac-92e5-446dc3b692ac)
