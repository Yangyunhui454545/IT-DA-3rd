package BOJ;
import java.util.*;

public class BOJ_������_1743 {
	static int M, N, K, res,cnt=1;
	static int map [][];
	static int[][] visit;
	static int [] dy= {0,0,1,-1};
	static int [] dx= {1,1,0,0};
	
	public static void dfs(int x, int y){
		
		for(int i=0; i<4; i++) { //�����Ⱑ �ִ� ���� �����¿츦 Ž���Ѵ�.
			int nx = x+dx[i];
			int ny = y+ dy[i];
			if(nx >= 0 && nx < N &&ny >= 0 && ny < M && visit[nx][ny] == 0 && map[nx][ny ]== 1) {
			visit[nx][ny] = 1;
			cnt++;
			dfs(nx, ny);
			}
		}
		
	}
	
	public static void main(String args[])  {		
       Scanner sc = new Scanner(System.in);       
       
       M = sc.nextInt();
       N = sc.nextInt();
       K = sc.nextInt();
       
       map = new int[N][M];
       visit = new int[N][M];
       
       for(int i=0; i<K; i++) {
    	   int x = sc.nextInt();
    	   int y = sc.nextInt();
    	   
    	   map[x-1][y-1] = 1;
       }
       for(int i=0;i<N; i++) {
    	   for(int j=0;j<M; j++) {
    		   if(visit[i][j]==0 && map[i][j]==1) { //�湮���� ���� �� �� �����Ⱑ �ִ� ��
    			   cnt=0; 
    			   dfs(i, j); //dfs�� ������.
    			   if(cnt> res) //���� �� ū ������ res�� �ٲ۴�.
    				   res = cnt;
    		   }
    	   }
       }
       System.out.println(res);
	}
}
