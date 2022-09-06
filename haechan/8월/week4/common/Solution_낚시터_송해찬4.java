import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_낚시터_송해찬4 {

	static int N, ans;
	static int[] fisher;
	static int[][] enter;
	
	// 순열용
	static int[] numbers;
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> numbersPerm; 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 순열 만들어놓고 시작
		numbers = new int[3];
		isVisited = new boolean[3];
		numbersPerm = new ArrayList<>();
		perm(0);
//		System.out.println(numbersPerm);
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			enter = new int[4][2];
			for(int i=1; i<=3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				enter[i][0] = Integer.parseInt(st.nextToken());
				enter[i][1] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			// 가운데 왼쪽 먼저 보는 bfs로 최솟값 구해보기
			leftStart();
			// 가운데 오른쪽 먼저 보는 bfs로 최솟값 구해보기
			rightStart();			
//			System.out.println(Arrays.toString(fisher));
			System.out.printf("#%d %d%n", tc, ans);
		}
		
	}
	
	static void bfsLeft(int x, int people) {
		
		int d = 1;
		while(true) {
			// 입구 바로 앞에 확인
			if(fisher[x] == -1) { 
				fisher[x] = d;
				people--;
				if(people == 0) break;
			}
			// 왼쪽 확인
			if(x-d>=1 && fisher[x-d] == -1) {
				fisher[x-d] = d+1;
				people--;
				if(people == 0) break;
			}
			
			// 오른쪽 확인
			if(x+d<=N && fisher[x+d] == -1) {
				fisher[x+d] = d+1;
				people--;
				if(people == 0) break;
			}
			// 왼쪽 끝에 도달했는데 people이 남은경우
			if(x-d<1) {
				for(int i=1; i<=N; i++) {
					if(fisher[i] == -1) {
						// i번째에 나머지 배치
						fisher[i] = Math.abs(x-i)+1;
						people--;
					}
					if(people==0) break;
				}
				if(people==0) break;
			}
			d++;
		}
	}
	
	static void bfsRight(int x, int people) {
		
		int d = 1;
		while(true) {
			// 입구 바로 앞에 확인
			if(fisher[x] == -1) { 
				fisher[x] = d;
				people--;
				if(people == 0) break;
			}
			// 오른쪽 확인
			if(x+d<=N && fisher[x+d] == -1) {
				fisher[x+d] = d+1;
				people--;
				if(people == 0) break;
			}
			// 왼쪽 확인
			if(x-d>=1 && fisher[x-d] == -1) {
				fisher[x-d] = d+1;
				people--;
				if(people == 0) break;
			}
			// 오른쪽 끝에 도달했는데 people이 남은경우
			if(x+d>N-1) {
				for(int i=N; i>0; i--) {
					if(fisher[i] == -1) {
						// i번째에 나머지 배치
						fisher[i] = Math.abs(x-i)+1;
						people--;
					}
					if(people==0) break;
				}
				if(people==0) break;
			}
			d++;
		}
	}
	
	static void leftStart() {
		for(int a=0; a<numbersPerm.size(); a++) {
			fisher = new int[N+1];
			for(int i=1; i<=N; i++) {
				// 미방문 처리
				fisher[i] = -1;
			}
			bfsLeft(enter[numbersPerm.get(a).get(0)][0], enter[numbersPerm.get(a).get(0)][1]);
			bfsLeft(enter[numbersPerm.get(a).get(1)][0], enter[numbersPerm.get(a).get(1)][1]);
			bfsLeft(enter[numbersPerm.get(a).get(2)][0], enter[numbersPerm.get(a).get(2)][1]);
			int temp = 0;
			for(int i=1; i<=N; i++) {
				if(fisher[i] > 0) temp += fisher[i];
			}
			ans = Math.min(ans, temp);
		}
	}
	
	static void rightStart() {
		for(int a=0; a<numbersPerm.size(); a++) {
			fisher = new int[N+1];
			for(int i=1; i<=N; i++) {
				// 미방문 처리
				fisher[i] = -1;
			}
			bfsRight(enter[numbersPerm.get(a).get(0)][0], enter[numbersPerm.get(a).get(0)][1]);
			bfsRight(enter[numbersPerm.get(a).get(1)][0], enter[numbersPerm.get(a).get(1)][1]);
			bfsRight(enter[numbersPerm.get(a).get(2)][0], enter[numbersPerm.get(a).get(2)][1]);
			int temp = 0;
			for(int i=1; i<=N; i++) {
				if(fisher[i] > 0) temp += fisher[i];
			}
			ans = Math.min(ans, temp);
		}
	}
	
	
	static void perm(int cnt) {
		if (cnt == 3) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i < numbers.length; i++) {
				temp.add(numbers[i]);
			}
			numbersPerm.add(temp);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (isVisited[i]) {
				continue;
			}
			numbers[cnt] = i+1;
			isVisited[i] = true;
			perm(cnt + 1);
			isVisited[i] = false;
		}
	}
}