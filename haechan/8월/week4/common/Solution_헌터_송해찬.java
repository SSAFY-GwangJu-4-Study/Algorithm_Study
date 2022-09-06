import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_헌터_송해찬 {

	static int N, objectSize, minTime;
	static boolean[] hunted, selected;
	static Point[] choice;
	static ArrayList<Point> list;
	
	static class Point{
		int x, y, num;

		public Point(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp!=0) list.add(new Point(i, j, temp));
				}
			}
			objectSize = list.size();
			selected = new boolean[objectSize];
			hunted = new boolean[objectSize/2+1];
			choice = new Point[objectSize];
			minTime = Integer.MAX_VALUE;
			perm(0);
			System.out.printf("#%d %d%n", tc, minTime);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == objectSize) {
			int temp = 0;
			// 첫번째 방문지는 0,0에서 거리
			temp += choice[0].x + choice[0].y;
			for(int i=1; i<objectSize; i++) {
				temp += Math.abs(choice[i].x - choice[i-1].x)+ Math.abs(choice[i].y - choice[i-1].y); 
			}
			minTime = Math.min(minTime, temp);
			return;
		}
		
		for(int i=0; i<objectSize; i++) {
			if(!selected[i]) {
				// 고객일때
				if(list.get(i).num < 0) {
					// 몬스터 안잡혀있으면 넘어감
					if(!hunted[Math.abs(list.get(i).num)]) continue;
					// 몬스터 잡혀있으면 다음 순열 만들기
					else {
						selected[i] = true;
						choice[cnt] = list.get(i);
						perm(cnt+1);
						selected[i] = false;
					}
				}
				// 몬스터일때
				else {
					// 방문처리, 몬스터 잡힘 처리
					selected[i] = true;
					hunted[list.get(i).num] = true;
					choice[cnt] = list.get(i);
					perm(cnt+1);
					selected[i] = false;
					hunted[list.get(i).num] = false; 
				}
			}
		}
	}
}
