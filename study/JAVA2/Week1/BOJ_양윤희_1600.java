package BOJ;
import java.util.*;

public class BOJ_¾çÀ±Èñ_1600 {
	static int K,W,H;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {1,-1,0,0,2,2,-2,-2,1,1,-1,-1};
	static int[] dy= {0,0,1,-1,1,-1,1,-1,2,-2,2,-2};
	
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);       
	    K = sc.nextInt();
	    W = sc.nextInt();
	    H = sc.nextInt();
	    visited = new boolean[H][W][K+1];
	    map = new int[H][W];
	    
	    for(int i=0; i<H; i++) {
	    	for(int j=0; j<W; j++)
	    		map[i][j] = sc.nextInt();
	    }
	    for(int i=0; i<K; i++) {
	    	visited[0][0][i] = true;
	    }
	    
	    if(W==1 && H==1) System.out.print(0);
	    else System.out.print(bfs());
	}
	
	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0));
		int time =0;
		
		while(!q.isEmpty()) {
			int length = q.size();
			for(int i=0; i<length; i++) {
				Point p = q.poll();
				if(p.x==H - 1 &&p.y==W -1) return time;
				
				for(int j=0; j<12; j++) {
					int sx = p.x + dx[j], sy=p.y +dy[j];
					if(!(sx>=0 && sx<H && sy >=0 && sy<W && map[sx][sy]==0)) continue;
					
					if(j<4) {
						if(!visited[sx][sy][p.count]) {
							visited[sx][sy][p.count]=true;
							q.add(new Point(sx,sy,p.count));
						}
					}else {
						int nextCount = p.count + 1;
						if(nextCount<=K && !visited [sx][sy][nextCount]) {
							visited[sx][sy][nextCount] = true;
							q.add(new Point(sx,sy,nextCount));
						}
					}
				}
			}
			time++;
		}
		return -1;
	}

}
class Point{
	int x;
	int y;
	int count;
	
	public Point(int x, int y, int count) {
		this.x = x;
		this.y=y;
		this.count= count;
	}
}
