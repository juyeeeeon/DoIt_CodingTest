package graph.ex08_7_최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17472_다리만들기2 {
	
	static int[] dr = {-1, 0, 1, 0}; //direction row
	static int[] dc = {0, 1, 0, -1}; //direction column
	
	static int N, M; //세로, 가로
	static int sNum; //for 섬 넘버링 , 섬의 개수
	static int[][] map;
	static boolean[][] visited;
	static int[] parent; //for union-find
	
	static ArrayList<ArrayList<int[]>> sumList; //섬 리스트
	static ArrayList<int[]> mList; //sumList의 부분arraylist
	static PriorityQueue<Edge> queue; //for minimum spanning tree, 섬 간의 엣지 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로
		M = Integer.parseInt(st.nextToken()); //가로
		
		
		map = new int[N][M];
		visited = new boolean[N][M]; 

		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		///////////////////////////////////////////////////////////////
		//섬마다 숫자로 넘버링하기
		sNum = 1; //섬 넘버링, 섬의 개수
		sumList = new ArrayList<ArrayList<int[]>>();
		for(int i=0; i<N; i++) { //섬 넘버링과정
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0 && visited[i][j] != true) {//바다가 아니고 방문하지 않았으면
					BFS(i, j);
					sNum++;
					sumList.add(mList); //하나의 섬을 mList에 담고 그것을 sumList에, sumList에는 모든 섬이 인접리스트로 구현되어 있음.
				}
			}
		}
		
		//////////////////////////////////////////////////////////////
		//섬의 각 지점에서 만들 수 있는 모든 간선을 저장
		queue = new PriorityQueue<Edge>(); //for MST, 가중치 기준 오름차순 정렬
		for(int i=0; i<sumList.size(); i++) {
			ArrayList<int[]> now = sumList.get(i);
			for(int j=0; j<now.size(); j++) {
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				int now_S = map[r][c];
				
				//4방향 탐색
				for(int d=0; d<4; d++) {
					int tempR = dr[d];
					int tempC = dc[d];
					int length = 0;
					
					while(r+tempR >= 0 && r+tempR < N && c+tempC >= 0 && c+tempC < M) {
						//같은 섬이면 간선을 만들 수 없음
						if(map[r+tempR][c+tempC] == now_S) break;
						else if(map[r+tempR][c+tempC] != 0) {
							if(length > 1) //다른 섬 -> 간격이 1이상일 때 간선으로 더해줌
								queue.add(new Edge(now_S, map[r+tempR][c+tempC], length));
							break; //다른 섬 찾았으면 끝
						}else {//바다이면 다리(엣지)의 길이를 연장
							length++;
						}
						
						if(tempR<0) tempR--;
						else if(tempR>0) tempR++;
						else if(tempC<0) tempC--;
						else if(tempC>0) tempC++;
					}
				}
			}
		}
		//////////////////////////////////////////////////////////////
		//유니온파인드리스트 초기화
		//대표노드를 자기 자신으로 초기화 하기
		parent = new int[sNum]; //이 시점에서 sNum은 (섬의 수 + 1)임.
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		int useEdge = 0;
		int result = 0; //모든 섬을 연결하는 다리 길이의 최솟값
		
		while(!queue.isEmpty()) {
			Edge now = queue.poll(); //엣지의 가중치가 작은 것부터 poll
			// 같은 부모가 아니라면 -> 연결해도 사이클이 생기지 않는다면
			if(find(now.start) != find(now.end)) {
				union(now.start, now.end);
				result += now.weight;
				useEdge++;
			}
		}
		
		//최소신장트리의 엣지는 V-1 개이다.
		//섬의 넘버링은 1부터고 우리는 
		if(useEdge == (sNum-1) - 1) System.out.println(result); //(sNum-1) : 섬의 개수(53라인에서 sNum++이므로)
		else System.out.println(-1); //모든 섬을 연결하는 것이 불가능
		
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		parent[b] = a;
	}

	private static int find(int i) {
		if(parent[i] == i) return i;
		
		return parent[i] = find(parent[i]);
	}

	//BFS를 통해 하나의 섬을 묶음
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		mList = new ArrayList<int[]>();
		
		int[] start = {i, j};
		queue.add(start);
		mList.add(start); 
		
		visited[i][j] = true;
		map[i][j] = sNum; //섬 넘버링
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int r = now[0];
			int c = now[1];
			
			//4방향 탐색
			for(int d=0; d<4; d++) {
				int tempR = dr[d];
				int tempC = dc[d];
				
				while(r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
					//방문한 적이 없고 바다가 아니면 같은 섬
					if(visited[r+tempR][c+tempC] == false && map[r+tempR][c+tempC] != 0) {
						addNode(r+tempR, c+tempC, queue);
					}else break; 
					
					//범위 넓히며 같은 섬인 좌표 찾기
					if(tempR<0) tempR--;
					else if(tempR>0) tempR++;
					else if(tempC<0) tempC--;
					else if(tempC>0) tempC++;
				}
			}
		}
	}

	private static void addNode(int i, int j, Queue<int[]> queue) {
		map[i][j] = sNum;
		visited[i][j] = true;
		int[] tmp = {i, j};
		mList.add(tmp); //mList에 하나의 섬을 구성하는 좌표들을 추가하고
						//하나의 섬을 구성하는 mList을 BFS가 끝났을 때 sumList에 추가함
		queue.add(tmp);
	}

	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}

}
