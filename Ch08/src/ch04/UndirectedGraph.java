package ch04;


//그래프를 matrix로 표현하기
public class UndirectedGraph {

	private int count;		//몇개 있는지
	private int[][] vertexMatrix;		//2차원 배열

	public UndirectedGraph(int count) {	//몇개짜리 그래프인지 count로 받음.
		this.count = count;		//몇개인지 count에 집어넣음
		vertexMatrix = new int[count][count];	//count만큼의 2차원배열 생성을 생성하여 matrix를 만듦.
	}

	//간선에 대한 정보
	//어디서 어디로 연결되어있는지 from, to, undirectedgraph이기 때문에 weight는 똑같은 값으로 주면 됨.
	public void addEdges(int from, int to, int weight) {	
		//directedgraph에서는 from, to를 정확하게 써야한다.
		vertexMatrix[from][to] = weight;
		vertexMatrix[to][from] = weight;
	}

	//밖에서 필요할 수 있으므로 반환하여 그래프 생성
	public int[][] getMatrix() {	
		return vertexMatrix;

	}

}
