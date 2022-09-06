import java.util.Scanner;

public class Main_1303_전쟁_전투 {
	public static char [][] map;
	public static boolean [][] selected;
	public static int me, you, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new char[n][m];
		selected = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.next().charAt(0);
			}
		}
		while(cnt < m*n) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(selected[n][m] != false) continue;
					//아직 선택(계산)되지 않은 애들의 경우
					
				}
			}
		}
		
	}
	

}
