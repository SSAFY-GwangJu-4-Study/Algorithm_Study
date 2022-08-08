import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11650_최지성 {

	static class Point implements Comparable<Point> {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point p) {
			if (this.x > p.x) {
				return 1;
			} else if (this.x == p.x) {
				if (this.y > p.y)
					return 1;
				else
					return -1;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		List<Point> points = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points.add(new Point(x, y));
		}

		StringBuilder sb = new StringBuilder();

		Collections.sort(points);

		for (int i = 0; i < N; i++) {
			sb.append(points.get(i).x + " " + points.get(i).y + "\n");
		}

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

//	// merge sort
//	public static void sort(int[][] points, int lo, int hi) {
//		if (lo < hi) {
//			// 분할
//			int mid = (lo + hi) / 2;
//			sort(points, lo, mid);
//			sort(points, mid + 1, hi);
//
//			// 병합
//			int[][] tmp = new int[points.length][2];
//			int p = lo;
//			int q = mid + 1;
//			int idx = p;
//
//			while (p <= mid || q <= hi) {
//				// 조건 1 : 뒤쪽 배열의 모든 원소를 가져왔을 때
//				// 조건 2 : 아직 앞쪽 배열에 원소가 남아있고, 앞쪽 배열의 현재 원소가 뒤쪽 배열의 현재 원소보다 작을 때
//				// 조건 3 : 아직 앞쪽 배열에 원소가 남아있고, 앞쪽 배열의 현재 원소.x가 뒤쪽 배열의 현재 원소.x와 같으면서 y값이 작을 때
//				// 결과 : 앞쪽 배열의 원소를 가져옴
//				if (q > hi || (p <= mid && ((points[p][0] < points[q][0]) || ((points[p][0] == points[q][0]) && (points[p][1] < points[q][1]))))) {
//					tmp[idx++] = points[p++];
//				} else {
//					tmp[idx++] = points[q++];
//				}
//			}
//
//			for (int i = lo; i <= hi; i++) {
//				points[i] = tmp[i];
//			}
//		}
//	}

//	// quick sort
//	public static void sort(Point[] points, int lo, int hi) {
//		if (lo >= hi) {
//			return;
//		}
//
//		int pivot = partition(points, lo, hi);
//
//		sort(points, lo, pivot - 1);
//		sort(points, pivot + 1, hi);
//	}
//

//	public static int partition(Point[] points, int left, int right) {
//		int lo = left;
//		int hi = right;
//		Point pivot = points[lo];
//		
//		while(lo < hi) {
////			 && (points[hi].x == pivot.x && points[hi].y > pivot.y) 
//			while(points[hi].x >= pivot.x && lo < hi) {
//				if(points[hi].x == pivot.x && points[hi].y < pivot.y) {
//					break;
//				}
//				
//				hi--;
//			}
////			 && (points[hi].x == pivot.x && points[hi].y < pivot.y)
//			while(points[lo].x <= pivot.x && lo < hi) {
//				if(points[lo].x == pivot.x && points[lo].y > pivot.y) {
//					break;
//				}
//				
//				lo++;
//			}
//			
//			swap(points, lo, hi);
//		}
//		
//		swap(points, left, lo);
//		
//		return lo;
//	}

//	// bubble sort
//	public static void sort() {
//		boolean changed = false;
//		do {
//			changed = false;
//
//			for (int i = 0; i < N - 1; i++) {
//				if (points[i][0] > points[i + 1][0]) {
//					swap(i, i + 1);
//					changed = true;
//				} else if (points[i][0] == points[i + 1][0]) {
//					if (points[i][1] > points[i + 1][1]) {
//						swap(i, i + 1);
//						changed = true;
//					}
//				}
//			}
//		} while (changed);
//	}

	public static void swap(int[][] points, int i, int j) {
		int[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}
}
