package ch05;

class MyGraph {
	private int count; // 노드 수
	private int[][] vertexMatrix; // matrix로 그래프 표시
	private int[] distance; // 특정 노드에 대한 각 노드의 최단 거리(남아있는 가장 가까운 거리값) 거리값이므로 int형
	private boolean[] visited; // 이미 방문하였는지.
	private static int UNLIMIT = 999999999; // 초기값. 999999999대신 integer max 넣어도 됨.

	public MyGraph(int count) {
		this.count = count;
		vertexMatrix = new int[count][count];
		distance = new int[count];
		visited = new boolean[count];	//거쳐간건 true, 기본값은 false

	}

	public void addEdges(int from, int to, int weight) {
		vertexMatrix[from][to] = weight;
		vertexMatrix[to][from] = weight;
	}

	public void calcShotestPath(int from) {

		for (int i = 0; i < count; i++) {
			distance[i] = UNLIMIT; // 초기값 넣음.
		}

		visited[from] = true; // from은 처음이므로 방문함.
		distance[from] = 0; // from은 처음이므로 거리는 0
		// 연결노드 distance갱신.
		for (int i = 0; i < count; i++) {
			// from과 바로 연결돼있는 노드들의 거리를 업데이트
			if (visited[from] && vertexMatrix[from][i] != 0) {
				distance[i] = vertexMatrix[from][i];
			}
		}

		// 처음 from은 미포함이므로 count-1
		for (int k = 0; k < count - 1; k++) {

			int min = UNLIMIT;
			int minIndex = -1;

			for (int i = 0; i < count; i++) {
				if (!visited[i] && distance[i] != UNLIMIT) { // 방문한 적이 없고, 거리가 UNLIMIT가 아닐때
					// 중간노드 없으면서 인접하면서 가장 가까운 노드를 minIndex에 넣음.
					if (distance[i] < min) {
						min = distance[i];
						minIndex = i;
					}
				}
			}

			// minIndex가 거쳐가는 노드의 인접노드 돌기.
			visited[minIndex] = true; // 가장 인접한 노드는 방문함.
			for (int i = 0; i < count; i++) {
				if (!visited[i] && vertexMatrix[minIndex][i] != 0) {
					// (처음 distance) > (주변 최단 노드 거리 + 그 노드와 자신의 거리)이면 후자로 distance 업데이트.
					if (distance[i] > distance[minIndex] + vertexMatrix[minIndex][i]) {
						distance[i] = distance[minIndex] + vertexMatrix[minIndex][i];
					}
				}
			}

		}
	}

	public void showDistance(int from) {
		for (int i = 0; i < count; i++) {
			System.out.println(from + "노드로부터 " + i + "노드의 최단 거리는 : " + distance[i]);
		}
	}
}

public class ShortestPath {

	public static void main(String[] args) {
		MyGraph graph = new MyGraph(6);
		graph.addEdges(0, 1, 1);
		graph.addEdges(0, 2, 4);
		graph.addEdges(1, 2, 2);
		graph.addEdges(2, 3, 1);
		graph.addEdges(3, 4, 8);
		graph.addEdges(3, 5, 3);
		graph.addEdges(4, 5, 4);

		graph.calcShotestPath(1); // 괄호 숫자의 노드로부터 최단거리를 구하는 것.
		graph.showDistance(1);

	}
}
