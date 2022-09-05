import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_김경삼 {
	static int kingX,kingY,stoneX,stoneY;
	static int[][]map;
	//R - L - B - T - RT - LT - RB -LB 순서 delta 작성
	static int[] deltaX= {1,-1,0,0,1,-1,1,-1};
	static int[] deltaY= {0,0,-1,1,1,1,-1,-1};
	public static void main(String[] args) throws IOException {
		//A = 65번
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		map = new int[8][8];
		
		String king =st.nextToken();
		kingX= king.charAt(0)-65;
//		System.out.println(kingX);
		kingY= king.charAt(1)-'1';
//		System.out.println(kingY);
		map[kingX][kingY]= 1; //킹 위치 =1
		
		String stone= st.nextToken();
		stoneX = stone.charAt(0)-65;
		stoneY = stone.charAt(1)-'1';
		map[stoneX][stoneY]=2; //스톤 위치=2
		
		int move = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<move;i++) {
			doMove(br.readLine(),kingX,kingY);
//			System.out.println(kingX);
//			System.out.println(kingY);
			
		}
		System.out.print((char)(kingX+65));
		System.out.print(kingY+1);
		System.out.println();
		System.out.print((char)(stoneX+65));
		System.out.print(stoneY+1);
		
	}
	
	private static void doMove(String order,int tmpX,int tmpY) {
		int direction = -1;
		switch (order) {
		case "R":
			direction =0;
			break;
		case "L":
			direction =1;
			break;
		case "B":
			direction =2;
			break;
		case "T":
			direction =3;
			break;
		case "RT":
			direction =4;
			break;
		case "LT":
			direction =5;
			break;
		case "RB":
			direction =6;
			break;
		case "LB":
			direction =7;
			break;
		}
		
		int nx = tmpX+deltaX[direction];
		int ny = tmpY+deltaY[direction];
		if(nx<0||ny<0||nx>=8||ny>=8) return;
		if(map[nx][ny]==2) {
			if(stoneX+deltaX[direction]<0||stoneX+deltaX[direction]>=8||stoneY+deltaY[direction]<0||stoneY+deltaY[direction]>=8) {
				return;
			}
			//돌과 만난 경우
			else {
				map[stoneX][stoneY]=0;
				stoneX+=deltaX[direction];
				stoneY+=deltaY[direction];
				map[stoneX][stoneY]=2;
			}
		}
		map[kingX][kingY]=0;
		kingX= nx;
		kingY= ny;
		
		map[kingX][kingY]=1;
		
	}
	
}
