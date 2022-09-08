import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_송해찬 {

	static int kx, ky, sx, sy, dx, dy;
	static int[][] grid = new int[8][8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String kPos = st.nextToken();
		kx = kPos.charAt(0) - 'A';
		ky = kPos.charAt(1) - '1';
		String sPos = st.nextToken();
		sx = sPos.charAt(0) - 'A';
		sy = sPos.charAt(1) - '1';
		
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++) {
			String cmd = br.readLine();
			move(cmd);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((char)(kx+'A')).append((char)(ky+'1')).append('\n');
		sb.append((char)(sx+'A')).append((char)(sy+'1'));
		System.out.println(sb);
	}
	
	static void move(String cmd) {
		switch (cmd)
        {
            case "R":
            {
                dx = 1;
                dy = 0;
                break;
            }
            case "L":
            {
                dx = -1;
                dy = 0;
                break;
            }
            case "B":
            {
            	dx = 0;
                dy = -1;
                break;
            }
            case "T":
            {
            	dx = 0;
                dy = 1;
                break;
            }
            case "RT":
            {
                dx = 1;
                dy = 1;
                break;
            }
            case "LT":
            {
                dx = -1;
                dy = 1;
                break;
            }
            case "RB":
            {
                dx = 1;
                dy = -1;
                break;
            }
            case "LB":
            {
                dx = -1;
                dy = -1;
                break;
            }
        }
		
		// 문제 잘읽기.. 킹이 먼저 움직이고, 돌에 막힌다면 돌 미는것
		// 킹 범위 확인, 돌 막히면 돌 범위 확인, 킹돌 세팅
		// 킹 범위 확인, 돌 안막히면 킹 세팅 
		if(kIsInside()) {
			// 위에 스위치문 dx, dy 둘다 초기화해줘야 조건 제대로 탐
			if(kx+dx==sx && ky+dy==sy) {
				if(sIsInside()) {
					kx += dx;
					ky += dy;
					sx += dx;
					sy += dy;
				}
			}
			else {
				kx += dx;
				ky += dy;
			}
		}
	}
	
	static boolean kIsInside() {
		int nx = kx+dx;
		int ny = ky+dy;
		if(nx>=0 && nx<8 && ny>=0 && ny<8) return true;
		else return false;
	}
	
	static boolean sIsInside() {
		int nx = sx+dx;
		int ny = sy+dy;
		if(nx>=0 && nx<8 && ny>=0 && ny<8) return true;
		else return false;
	}

}
