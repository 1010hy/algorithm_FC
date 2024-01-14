package ch06;

import java.util.Stack;

public class Robot {

	// 움직임을 표시할 변수
	public static int NUMDIRECTIONS = 4;		//방향이 4개
	public static int WIDTH = 8;
	public static int HEIGHT = 8;

	Stack<Move> stack = new Stack<Move>();
	Move Move;
	Maze maze = new Maze();

	public int[][] DIRECTION_OFFSETS = {
			{ 0, 1 }, 		//아래쪽으로 이동.
			{ 1, 0 },		//오른쪽으로 이동.
			{ 0, -1 }, 		//위쪽으로 이동. -1로 설정한 이유는 지도를 벗어나기 때문
			{ -1, 0 } 		//왼쪽으로 이동.
	};

	public static int NOTVISIT = 0; //방문을 안하면 0으로 표시
	public static int WALL = 1;		//wall은 1
	public static int VISIT = 2;	//방문한건 2로 표시
	int[][] markArray = new int[8][8];

	//출구 찾기
	public void findPath(int startX, int startY, int endX, int endY) {

		boolean isEmpty = false;
		boolean isFound = false;
		int i = 0;

		Move start = new Move(startX, startY);

		start.direction = 0;
		stack.push(start);

		while (isEmpty == false && isFound == false) {

			//direction >= NUMDIRECTIONS일때 즉 모든 방향을 봤는데 길이 없을때 pop
			Move curPos = stack.pop();
			int x = curPos.x;
			int y = curPos.y;
			int direction = curPos.direction;

			while (isFound == false && direction < NUMDIRECTIONS) {

				//만약 direction이 3인 경우 
				//DIRECTION_OFFSETS[3][0]은 -1, [3][1]은 0이다.
				int newX = x + DIRECTION_OFFSETS[direction][0];	
				int newY = y + DIRECTION_OFFSETS[direction][1];	

				//4면이 미로의 크기를 벗어나지 않고, 뚫려있는 길(0)이고, visit한적이 없다면 
				if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT && maze.myMaze[newY][newX] == NOTVISIT
						&& markArray[newY][newX] == NOTVISIT) {
					Move newPosition = new Move(newX, newY);
					newPosition.direction = direction + 1;	//direction은 DIRECTION_OFFSETS의 행, +1 할때마다 위오아왼으로 움직임
					stack.push(newPosition);		//방문한걸 stack에 추가
					markArray[y][x] = VISIT;		//방문했다고 표시, 행열이기 때문에 yx

					x = newX;	//현위치 업데이트
					y = newY;	//현위치 업데이트
					direction = 0;

					//도착한 경우
					if (newX == endX && newY == endY) {
						isFound = true;
						//선생님 코드는 newPosition인스턴스를 사용하였는데 이게 있으면 (7,7)이 한번 더 출력됨..
//						newPosition.x = newX;
//						newPosition.y = newY;
//						newPosition.direction = 0;
//						stack.push(newPosition);
//						markArray[newY][newX] = VISIT;
						markArray[y][x] = VISIT;
					}
				} else
					direction++;	//4면이 미로의 크기를 벗어나거나, 벽(1)이거나, visit한적이 있으면  while문을 빠져나서 방향 다시 탐색
			} // end-of-while
			isEmpty = stack.isEmpty();	//스텍에 남은게 있으므로 isEmpty는 false
		} // end-of-while
	}

	//찾은 길 출력하기
	public void showPath() {
		int[][] resultArray = new int[8][8];
		boolean isEmpty = false;

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				resultArray[i][j] = maze.myMaze[i][j];
			}
		}

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				//maze.myMaze가 1이면 *표시
				if (maze.myMaze[i][j] == WALL) {	
					System.out.print("*");
				//방문한 건 | 표시
				} else if (markArray[i][j] == VISIT) {
					System.out.print("|");
				//길이 있는데 안간 건 빈칸
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}

		int i = 0;
		while (isEmpty == false) {
			Move move = stack.pop();
			int x = move.x;
			int y = move.y;
			resultArray[y][x] = VISIT;

			if (i > 0) {
				System.out.print("<-");
			}
			System.out.print("(" + x + "," + y + ") ");
			i++;
			isEmpty = stack.isEmpty();	//true가 되면 스텍이 비었으므로 while문 빠져나감.
		}
		System.out.println();
	}

}
