package hyewon.bfs_n_dfs_3;

import java.util.LinkedList;
import java.util.Queue;

public class problem_경주로건설 {
	static int n;
	static int answer = 0;
	static int[][] arr;
	static int[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Road{
		int x;
		int y;
		int cost;
		int dir;
		public Road(int x,int y,int cost,int dir){
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.dir = dir;
		}
	}
    public int solution(int[][] board) {
        n = board.length;
        arr = board;
        visited = board;
        answer = Integer.MAX_VALUE;  // 이거 이해하기!!!!!!!!!
        bfs(0,0,0,-1);
        return answer;
        
    }
    public static void bfs(int x, int y, int cost, int dir){
    	Queue<Road> q = new LinkedList<>();
    	q.offer(new Road(x,y,cost,dir));
    	arr[x][y] = 1;
    	
    	while(!q.isEmpty()){
    		Road road = q.poll();
    		int cx = road.x;
    		int cy = road.y;
    		
    		if(cx==n-1 && cy==n-1){  // 최종목적지에 도착했을 경우
        		answer = Math.min(answer, road.cost);
        	}		
    		for(int i=0; i<4; i++){
    			int nx = cx + dx[i];
    			int ny = cy + dy[i];
    			if(nx>=0&&nx<n&&ny>=0&&ny<n && (arr[nx][ny]==0 || arr[nx][ny]>=road.cost)){
    				if(road.dir==-1 || road.dir==i){
    					q.offer(new Road(nx,ny,road.cost+100,i));
    					arr[nx][ny] = road.cost+100; // 비용 정보 입력
    				}else{
    					q.offer(new Road(nx,ny,road.cost+600,i));
    					arr[nx][ny] = road.cost+600; // 비용 정보 입력
    				}
    			}
    		}
    	}
    }
}
