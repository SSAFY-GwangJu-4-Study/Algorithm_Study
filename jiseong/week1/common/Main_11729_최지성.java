import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_11729_최지성 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		sb.append("" + (int)(Math.pow(2, n) - 1) + "\n");
		hanoi(n, 1, 2, 3);
		
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}

	public static void hanoi(int n, int start, int temp, int end) {
		if (n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}

		hanoi(n - 1, start, end, temp); // n-1개 원판 옮기기
		sb.append(start + " " + end + "\n"); // 맨 밑 원판 옮기기
		hanoi(n - 1, temp, start, end); // n-1개 원판 옮기기
	}
}
