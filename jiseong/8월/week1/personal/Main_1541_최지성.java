import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1541_최지성 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		String[] addition = input.split("\\-");
		
		int[][] temp = new int[addition.length][];
		
		for(int i = 0; i < addition.length; i++) {
			String[] term = addition[i].split("\\+");
			temp[i] = new int[term.length];
			
			for(int j = 0; j < term.length; j++) {
				temp[i][j] = Integer.parseInt(term[j]);
			}
		}
		
		int sum = 0;
		
		for(int i = 0; i < temp[0].length; i++) {
			sum += temp[0][i];
		}
		
		for(int i = 1; i < temp.length; i++) {
			int tempSum = 0;
			
			for(int j = 0; j < temp[i].length; j++) {
				tempSum += temp[i][j];
			}
			
			sum -= tempSum;
		}
		
		bw.write("" + sum);
		
		bw.flush();
		br.close();
		bw.close();
	}

}
