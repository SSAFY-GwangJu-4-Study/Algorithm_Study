import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17829_송해찬 {

	static int[][] grid;
	static int secondMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(pooling(n, 0, 0));
		
	}

	// 분할정복/재귀 - size로 분할, r,c 로 타겟 잡기
	static int pooling(int size, int r, int c){
		if(size == 1) {
			return grid[r][c];
		}
		
		int n1 = pooling(size/2, r, c);
		int n2 = pooling(size/2, r+size/2, c);
		int n3 = pooling(size/2, r, c+size/2);
		int n4 = pooling(size/2, r+size/2, c+size/2);
		
		int[] temp = new int[] {n1, n2, n3, n4};
		Arrays.sort(temp);
		return temp[2];
	}
}
