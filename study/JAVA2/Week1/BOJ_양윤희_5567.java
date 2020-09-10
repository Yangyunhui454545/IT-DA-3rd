package BOJ;
import java.util.*;
/*
�ð� ���⵵: O(n+m)
����� �˰���: BFS(�ʺ� �켱 Ž��)
����� �ڷᱸ��: ���� ����Ʈ, �迭
*/
class BOJ_������_5567 {
    static final int max_int_N = 501; //�ִ� +1
    static final int max_int_m = 10001; //�ִ� +1

    static int n, m, a, b, cnt=0;
    static int[] check = new int[max_int_m]; //check�� �ִ� �Ÿ��� ������ �迭
    static ArrayList<Integer> v[] = new ArrayList[max_int_N]; //������ ������ ���� ����Ʈ

    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);        //n������ ��, m ������ ��
        n = sc.nextInt();
        m = sc.nextInt();
        
        //�Ÿ� ������ ������ check �迭�� -1�� �ʱ�ȭ�Ѵ�.
        for(int i=1; i<=n; i++) {
            check[i] = -1;
            v[i] = new ArrayList<>();
        }
        //���� ����
        for(int i=0; i<m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            //����� �׷����� �����.
            v[a].add(b);
            v[b].add(a);
        }
        //�ʺ� �켱 Ž�� ����
 
            System.out.println(bfs());
        
    }

    public static int bfs(){
        Queue<Integer> q = new LinkedList<>(); //q ����
        check[1] = 0; //������������ �ִ� �Ÿ��� 0
        q.add(1); //ť�� ������ �־��ֱ�

        //ť�� ������� ������ ���
        //ť�� ����ٴ� �ǹ̴� �������� ����� ��� �ٸ� �������� �湮�ߴٴ� �ǹ�
        while(!q.isEmpty()){
        	//q���� ���� �տ� �ִ� ������ �־��ش�.
            int node = q.poll();
            
            //������ �������� ����� �ٸ� ��� �������� next�� �ִ´�.
            for(int i=0; i<v[node].size(); i++){
                int next = v[node].get(i);
                //���� �湮���� �ʾҴٸ�
                if(check[next] == -1){
                	//q�� �ֱ� ���� �湮������ üũ�Ѵ�.
                	//���⼭ üũ���ϸ� �ٸ� ������ ���⸦ �� �湮�� ���� ����
                	//������ Ÿ�� �̵��� ������ 1�� ����, ���� ���������� �Ÿ��� 1�� �����ش�.
                    check[next] = check[node] + 1;
                    //ģ�� ������ �Ÿ��� 2�϶������� ������ �Ѵ�.
                    if(check[next] ==3) {
                    	return cnt;
                    }
                    //���� ������ ť�� �ִ´�.
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}