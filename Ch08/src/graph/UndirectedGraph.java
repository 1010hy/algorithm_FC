package graph;


//그래프를 matrix로 표현하기
public class UndirectedGraph {

	private int count;		//몇개 있는지
	private int[][] vertexMatrix;		//2차원 배열

	public UndirectedGraph(int count) {
		this.count = count;		//몇개인지 count에 집어넣음
		vertexMatrix = new int[count][count];	//count만큼의 2차원배열 생성
	}

	//간선에 대한 정보
	public void addEdges(int from, int to, int weight) {	//어디서 어디로 연결되어있는지
		//방향성이 없으므로 하단처럼만 작성해도 됨.
		vertexMatrix[from][to] = weight;
		vertexMatrix[to][from] = weight;
	}

	//반환하여 그래프 생성
	public int[][] getMatrix() {
		return vertexMatrix;

	}

}
