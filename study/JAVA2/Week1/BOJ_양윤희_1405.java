package BOJ;

import java.util.Scanner;


/*
 �ð� ���⵵: O(|V|+|E|)
 ����� �˰���: DFS(���� �켱 Ž��)
����� �ڷᱸ��: ������ �迭, ���
*/
class BOJ_������_1405 {
	
	static int n;
	static double ans=0, p[];
	static int vy[] = {0,0,1,-1}; //Y�� 
	static int vx[] = {1,-1,0,0}; //X��
	static boolean map[][]; //�湮�ߴ��� Ȯ���� �� �ִ� bool�� �迭



	public static void dfs(int x, int y, int dep, double res){
		if(dep ==n) { //���̰� N�� ������ ���� ��ȯ�Ѵ�. 
			ans +=res;
			return;
		}
		for(int i=0; i<4; i++) { //������������ �̵�
			int ny =y+vy[i]; 
			int nx = x+vx[i];
			if(ny>=29 || nx>=29 || ny<0 || nx<0) continue; //n�� ������ �Ѿ�� �ݺ��� ������
			
			if(!map[ny][nx]) {
				map[nx][nx] =true; 
				dfs(ny,nx,dep+1,res*p[i]);
				map[nx][nx] =false; //�湮�� ������ ����
				}
			}
			
		}

	public static void main(String args[])  {		
		
       Scanner sc = new Scanner(System.in);       
       
       p = new double[4];
       map = new boolean[29][29];
       
       n = sc.nextInt();
       for(int j=0; j<4; j++) {
    	   p[j] = sc.nextInt() * 0.01;
       }
       map[14][14] = true; //���� ��ġ 
       dfs(14,14,0,1.0); //(14,14)�� ��ġ���� ����
       System.out.printf("%.10f", ans);
	}
}