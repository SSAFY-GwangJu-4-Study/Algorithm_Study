import java.util.ArrayList;
import java.util.Scanner;

public class Main_2477_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt(); // 1제곱미터 당 참외 개수

		int[][] move = new int[6][2];

		for (int i = 0; i < 6; i++) {
			move[i][0] = sc.nextInt();
			move[i][1] = sc.nextInt();
		}

		int hmax = 0;
		int vmax = 0;

		for (int i = 0; i < 6; i++) {
			if (move[i][0] == 3 || move[i][0] == 4)
				vmax = Math.max(vmax, move[i][1]);
			else
				hmax = Math.max(hmax, move[i][1]);
		}

		int idx = -1; // 처음 나온 큰 사각형의 한 변의 길이(가로든 세로든 상관 없음)

		// 가로의 제일 긴 변 -> 세로의 제일 긴 변 or 세로의 제일 긴 변 -> 가로의 제일 긴 변
		// 찾아서 뒷 변의 index를 가져오기
		// 찾는 이유는 방향에 상관없이 찾은 index + 2번째와 찾은 index + 3번쨰 길이가 작은 사각형의 길이가 되기 때문
		for (int i = 0; i < 6; i++) {
			if (move[i][1] == vmax || move[i][1] == hmax) {
				if (move[(i + 1) % 6][1] == vmax || move[(i + 1) % 6][1] == hmax) {
					idx = (i + 1) % 6;
					break;
				}
			}
		}

		int l1 = move[(idx + 2) % 6][1]; // 작은 사각형 한 변의 길이
		int l2 = move[(idx + 3) % 6][1]; // 작은 사각형 나머지 한 변의 길이

		int area = hmax * vmax - l1 * l2;
		
		System.out.println(area * num);
	}

}
