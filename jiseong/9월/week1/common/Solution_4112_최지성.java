import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4112_최지성 {
	// 각 층의 시작값을 저장하는 배열(1층부터 시작)
	static int[] startNumber;
	static int start;
	static int end;
	static int minMove;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			minMove = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			// 보물과 민지의 위치가 바뀌어도 똑같기 때문에 무조건 위에서 아래로 내려간다고 가정
			start = node1 > node2 ? node2 : node1;
			end = node1 > node2 ? node1 : node2;

			int startFloor = findFloor(start);
			int endFloor = findFloor(end);
			int floorDiff = endFloor - startFloor;
			
			int startColumn = findColumn(start, startFloor);
			int endColumn = findColumn(end, endFloor);
			
			// 시작점에서 왼쪽으로만 내려갔을 때 위치가 x1, 오른쪽으로만 내려갔을 때 위치가 x2
			int x1 = startColumn;
			int x2 = startColumn + floorDiff;
			
			// 왼쪽으로만 내려갔을 때보다 왼쪽이면 다 내려간 후 왼쪽으로만 이동해주면 된다. 
			if(0 <= endColumn && endColumn < x1) {
				minMove = floorDiff;
				minMove += (x1 - endColumn);
			// 그 중간에 있으면 내려가기만 해도 도착 가능
			} else if(x1 <= endColumn && endColumn <= x2) {
				minMove = floorDiff;
			// 오른쪽으로만 내려갔을 때보다 오른쪽이면 다 내려간 후 오른쪽으로만 이동해주면 된다.
			} else if(x2 < endColumn && endColumn < endFloor) {
				minMove = floorDiff;
				minMove += (endColumn - x2);
			}
			
			System.out.println("#" + tc + " " + minMove);
		}

//		System.out.println(Arrays.toString(startNumber));
	}

	// 각 층의 시작값을 생성
	public static void init() {
		startNumber = new int[150];

		int accSum = 1;
		for (int i = 0; i < 150; i++) {
			startNumber[i] = accSum;
			accSum += i;
		}
	}

	// 값이 주어지면 그 값이 있는 층을 return
	public static int findFloor(int value) {
		int ret = 0;

		for (int i = 1; i < 150; i++) {
			if (startNumber[i] > value) {
				ret = i - 1;
				break;
			}
		}

		return ret;
	}

	// 값이 주어지면 그 값이 해당 층의 몇 번째에 있는지 return
	public static int findColumn(int value, int floor) {
		int ret = 0;

		for (int i = startNumber[floor]; i < startNumber[floor + 1]; i++) {
			if (i == value) {
				ret = i - startNumber[floor];
				break;
			}
		}

		return ret;
	}
}
