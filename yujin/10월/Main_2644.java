

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_2644 {
	
	static int n, a, b, m;
	static int[][] arr;
	static int[] d;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][n+1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 인접 행렬로 관계 만들어주기
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		// 촌수 적어놓을 배열
		d = new int[n+1];
		BFS(a, b);
		
		if(d[b] == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(d[b]);
		}
		sc.close();
	}
	private static void BFS(int s, int e) {
		Queue<Integer> q = new ArrayDeque<>();
		// 촌수 계산할 주체
		q.offer(s);
		
		while(!q.isEmpty()) {
			// 촌수 계산할 주체
			int temp = q.poll();
			// 주체와 대상이 만나면
			if(temp==e) {
				break;
			}
			// 주체!=대상일 경우 1부터 n까지 돌아주면서 확인
			for (int i = 1; i <= n; i++) {
				// 주체와 현재 탐색하는 대상이 연결되어 있고, 방문하지 않았으면
				if(arr[temp][i] == 1 && d[i] == 0) {
					// 주체와 그 대상과의 촌수 = 지금까지 타고 계산한 촌수+1
					d[i] = d[temp] + 1;
					// 현재 대상을 큐에 넣어줌
					q.offer(i);
				}
			}
		}
	}
}


