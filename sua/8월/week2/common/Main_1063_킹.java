import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {
	public static int chess[][];
	public static int kx, ky, sx, sy;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		chess = new int[8][8];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String king = st.nextToken();
		String stone = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		kx = king.charAt(1) - '0';//킹 행
		ky = king.charAt(0) - 'A';//킹 열
		sx = stone.charAt(1) - '0';//돌 행
		sy = stone.charAt(0) - 'A';//돌 열

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());			
			String command = st.nextToken();	
			
			move(command);
			//81 61 -> 81 61 -> 81 61 -> 81 61 -> 81 61
		}
		System.out.println((char)(ky + 'A') + "" +  kx);
		System.out.println((char)(sy + 'A') + "" +  sx);
	}
	
	public static void move(String s) {
		switch(s) {
		case "T":
			if(kx+1 > 8) return;
			else if(kx+1 == sx && ky == sy) {
				if(sx+1 > 8) return;
				else {
					kx++;
					sx++;
				}
			}else kx++;
			break;
			
		case "B":
			if(kx-1 < 1) return;
			else if(kx-1 == sx && ky == sy) {
				if(sx-1 < 1) return;
				else {
					kx--;
					sx--;
				}
			}else kx--;
			break;
			
		case "R":
			if(ky+1 > 7) return;
			else if(ky+1 == sy && kx == sx) {
				if(sy+1 > 7) return;
				else {
					ky++;
					sy++;
				}
			}else ky++;
			break;
			
		case "L":
			if(ky-1 < 0) return;
			else if(ky-1 == sy && kx == sx) {
				if(sy-1 < 0) return;
				else {
					ky--;
					sy--;
				}
			}else ky--;
			break;
			
		case "LT":
			if(ky-1 < 0 || kx+1 > 8) return;
			else if(ky-1 == sy && kx+1 == sx ) {
				if(sy-1 < 0 || sx+1 > 8) return;
				else {
					ky--;
					kx++;
					sy--;
					sx++;
				}
			}else {
				ky--;
				kx++;
				}
			break;
			
		case "LB":
			if(ky-1 < 0 || kx-1 < 1) return;
			else if(ky-1 == sy && kx-1 == sx ) {
				if(sy-1 < 0 || sx-1 < 1) return;
				else {
					ky--;
					kx--;
					sy--;
					sx--;
				}
			}else {
				ky--;
				kx--;
				}
			break;
			
		case "RT":
			if(ky+1 > 7 || kx+1 > 8) return;
			else if(ky+1 == sy && kx+1 == sx ) {
				if(sy+1 > 7 || sx+1 > 8) return;
				else {
					ky++;
					kx++;
					sy++;
					sx++;
				}
			}else {
				ky++;
				kx++;
				}
			break;
			
		case "RB":
			if(ky+1 > 7 || kx-1 < 1) return;
			else if(ky+1 == sy && kx-1 == sx ) {
				if(sy+1 > 7 || sx-1 < 1) return;
				else {
					ky++;
					kx--;
					sy++;
					sx--;
				}
			}else {
				ky++;
				kx--;
				}
			break;
		}
		
		
	}
	
}
