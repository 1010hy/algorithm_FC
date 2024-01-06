package ch04;

import java.util.Stack;

public class DfsSearch {
	int count;		
	boolean[] visited;		//노드 수만큼의 배열, 기본적으로 처음 생성시에는 false임.
	Stack<Integer> stack;	//stack이 필요, 노드이므로 integer
	int[][] matrix;			// UndirectedGraph 에서 matrix정보 가져옴

	public DfsSearch(int count) {
		this.count = count;				//노드수만큼
		visited = new boolean[count];	//방문 표시도 노드수(count)만큼 배열 생성
		stack = new Stack<Integer>();	//stack으로 노드 들아갔다 나왔다 표시
	}

	public void dfsTraversal() {

		stack.push(0);		//stack에 넣기, 0부터 돌 것임.
		visited[0] = true;	//stack에 넣은 0을 또 넣으면 안되므로 true

		while (stack.size() != 0) {	//stack이 빌 때까지
			int node = stack.pop();	//stack에 있는 인접한 걸 꺼냄(pop)

			System.out.print(node + "  "); //node 꺼냄 -> 찍히는 것

			for (int j = 0; j < count; j++) {	//count만큼
				if (matrix[node][j] != 0 && !visited[j]) {	//연결이 되어있고(node와 j가 연결되어있으면 0이 아님), 스텍에 들어간 적 없다면(false이면)
					stack.push(j);							//push(집어넣음)
					visited[j] = true;						//집어넣었다는 방문표시 체크.(true)
				}
			}

		}
	}

	//그래프 그림
	public static void main(String[] args) {

		int count = 8;
		UndirectedGraph graph = new UndirectedGraph(count);		//count만큼 그래프 그림
		DfsSearch dfsSearch = new DfsSearch(count);

		//엣지
		//방향이 없기 때문에 모든 weight가 1
		graph.addEdges(0, 1, 1);	// 0과 1이 연결
		graph.addEdges(0, 2, 1);	// 0과 2가 연결
		graph.addEdges(1, 3, 1);	// 1과 3이 연결 ...
		graph.addEdges(1, 4, 1);
		graph.addEdges(2, 5, 1);
		graph.addEdges(2, 6, 1);
		graph.addEdges(4, 5, 1);
		graph.addEdges(3, 7, 1);

		//UndirectedGraph 에서 matrix 가져와서 그래프 그림
		dfsSearch.matrix = graph.getMatrix();
		dfsSearch.dfsTraversal();	//잘 찍히는지 검사

	}

}
