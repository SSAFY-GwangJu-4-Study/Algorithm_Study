import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851_숨바꼭질2 {
	static int[] delta = {-1,1,2};
	static int cnt, res = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		bfs(n,m);
		System.out.println(res);
		System.out.println(cnt);
		sc.close();
	}
	
	private static void bfs(int n, int m) {
		Queue<Integer> queue = new LinkedList<>();
		int[] move = new int[100_001];
		queue.offer(n);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(res<move[cur]) return; // res보다 더 많이 움직이면 종료.
			if(move[cur]<=res&&cur==m) { // 이전탐색보다 빠르게 도착지에 도착한 경우 최솟값 갱신 후 카운트 증가
				res=move[cur];
				cnt++;
			}
			
			for(int i=0;i<3;i++) {
				int next = cur;
				if(i==2) {
					next =cur*delta[i];
				}else {
					next = cur+delta[i];
				}
				
				if(next>=0&&next<100001) {
					if(move[next]==0||move[next]>=move[cur]+1) { //첫방문이거나, 이전 방문보다 빠르게 도착한 경우.
						move[next]= move[cur]+1;
						queue.offer(next);
					}
				}
			}
		}
	}
}
