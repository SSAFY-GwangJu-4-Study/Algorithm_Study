import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_송해찬 {

	static int n, R, C, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visit((int)Math.pow(2, n), 0, 0);
		
	}
	
	// 재귀 - 사이즈를 반씩 줄여가면서 사분면 위치 찾아가기 
	// 매개변수 - 찾는 범위 size, 사분면 시작점 r, c
	// 기저조건 - size가 1이 되면 종료
	
	// n=3 기준 초반 0, 16, 32, 48 시작 - size/2 * size/2 * i
	static void visit(int size, int r, int c) {
		if(size==1) {
			System.out.println(cnt);
			return;
		}
		
		int halfSize = size/2;
		// 1 사분면
		if(R< r+halfSize && C< c+halfSize) {
			cnt += halfSize*halfSize * 0 ;
			visit(halfSize, r, c);
		}
		// 2 사분면
		else if(R< r+halfSize && C>= c+halfSize) {
			cnt += halfSize*halfSize * 1 ;
			visit(halfSize, r, c+halfSize);
		}
		// 3 사분면
		else if(R>= r+halfSize && C< c+halfSize) {
			cnt += halfSize*halfSize * 2 ;
			visit(halfSize, r+halfSize, c);
		}
		// 4 사분면
		else if(R>= r+halfSize && C>= c+halfSize) {
			cnt += halfSize*halfSize * 3 ;
			visit(halfSize, r+halfSize, c+halfSize);
		}
		
	}
}
