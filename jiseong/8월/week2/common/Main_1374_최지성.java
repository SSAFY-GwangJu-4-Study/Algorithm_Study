import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1374_최지성 {
	public static int countOfClassRoom;
	public static int duplicatedClass;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] claaass = new int[N][2];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, " ");

			st.nextToken(); // 번호 버리기
			claaass[i][0] = Integer.parseInt(st.nextToken());
			claaass[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(claaass, (int[] arr1, int[] arr2) -> {
			if (arr1[0] == arr2[0])
				return arr1[1] - arr2[1];
			return arr1[0] - arr2[0];
		});
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int t = claaass[i][0];	// i번째 수업 시작
			duplicatedClass++;		// 겹치는 수업 개수 증가
			q.offer(claaass[i][1]);
			
			if(!q.isEmpty()) {
				if(q.peek() <= t) {
					q.poll();
					duplicatedClass--;
				}
			}
			
			countOfClassRoom = Math.max(countOfClassRoom, duplicatedClass);
		}
		
		System.out.println(duplicatedClass);
	}
}
