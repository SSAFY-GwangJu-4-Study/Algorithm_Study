import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_김선규 {
	
	static int N, startScore, linkScore, min = Integer.MAX_VALUE;
	static int[] start;
	static int[][] team;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// input end
		
		start = new int[N/2]; // start팀 고르기
		visited = new boolean[N]; // 방문체크
		
		
		// 순열로 팀을 짠 다음 능력치 차이 비교
		perm(0, 0);
		
		System.out.println(min);
		
	}
	
	public static void perm(int idx, int cnt) {
		if(idx==N/2) { // 팀고르기 완료
			
			startScore = 0;
			linkScore = 0;
			calc(); // 점수 계산 메서드
			
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			start[idx] = i;
			perm(idx+1, i+1);
			visited[i] = false;
		}
	}
	
	public static void calc() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(visited[i]) { // i가 참일 때
					if(visited[j]) { // j도 참이라면
						startScore += team[i][j]; // 스타트팀 점수 추가
					}
				}
				
				if(!visited[i]) { // i가 거짓일 때
					if(!visited[j]) { // j도 거짓이라면
						linkScore += team[i][j]; // 링크팀 점수 추가
					}
				}
			}
		}
		
		int diff = Math.abs(startScore - linkScore);
		min = Math.min(diff, min);
	}

}

