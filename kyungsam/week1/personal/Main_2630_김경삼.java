import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2630_김경삼 {
	static int[][] map;
	static int N, zeroCount,oneCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N= Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int divider = N;
		find(0,0,divider);
		System.out.println(zeroCount);
		System.out.println(oneCount);
	}
	/**
	* N 만약 입력8 받으면 8x8 map 생성. 경우의수 8*8 4*4 2*2 1*1 종이들 생성
	* n*n 배열의 원소가 모두 같은걸 찾고 count..?
	* count 한 부분은 2로 바꿔서 탐색 안해도 되지 않을까
	*/
	
	//map 탐색 부분 divider 개수를 절반으로 줄여가면서 check 하는 부분.
	static void find(int i,int j, int divider) {
		if(check(i,j,divider)) {
			if(map[i][j]==0) zeroCount++;
			else oneCount++;
			return;
		}
		
		divider /=2;
			find(i,j,divider);
			find(i+divider,j,divider);
			find(i,j+divider,divider);
			find(i+divider,j+divider,divider);
	}
	// divider로 나눈 각 범위에서 check하는 부분.
	public static boolean check(int startI, int startJ,int divider) {
		int input= map[startI][startJ];
		for(int i=startI;i<startI+divider;i++) {
			for(int j= startJ;j<startJ+divider;j++) {
				if(map[i][j]!=input) return false;
			}
		}
		return true;
	}
}
