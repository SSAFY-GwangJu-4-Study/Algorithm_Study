import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;
//	G3 나무 재테크
public class Main_16235 {
	static class Tree {
		int x, y, z;
		boolean alive;

		public Tree(int z) {
			super();
			this.z = z;
			this.alive = true;
		}

		public Tree(int z, boolean alive) {
			super();
			this.z = z;
			this.alive = alive;
		}

		public Tree(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.alive = true;
		}

		@Override
		public String toString() {
			return "Tree [나이=" + z + ", 생존 여부=" + alive + "]";
		}
	}

	static int N, M, K;
	static int[][] A;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
	static ArrayList<Tree>[][] t;
	static int k;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N x N 배열
		M = Integer.parseInt(st.nextToken()); // 심은 나무의 개수
		K = Integer.parseInt(st.nextToken()); // K년이 지난 후 살아있는 나무
		map = new int[N][N]; // 현재 양분
		t = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				t[i][j] = new ArrayList<Tree>();
			}
		}
		A = new int[N][N]; // 겨울에 추가되는 양분
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 문제 오류...?
//			int y = Integer.parseInt(st.nextToken()); // 가로
//			int x = Integer.parseInt(st.nextToken()); // 세로
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken()); // 나무의 나이
			t[x - 1][y - 1].add(new Tree(z));
		}
		/* 입력 받기 끝 */

		k = 0;
		ans = 0;
		tree();
		System.out.println(ans);
	}

	private static void tree() {
		while (true) {
			// 봄
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (t[i][j].size() > 0) {
//						System.out.println(k + " to 좌표 : " + i + " " + j + " " + t[i][j].toString());
						for (int s = 0; s < t[i][j].size(); s++) {
							if (t[i][j].get(s).alive == true) {
								int age = t[i][j].get(s).z;
								// 양분을 먹을 수 있을 때
								if (map[i][j] >= age) {
									// 자신의 나이만큼 양분을 먹고
									map[i][j] -= age;
									// 나이가 1 증가한다
//									Tree temp = new Tree(age + 1);
//									t[i][j].set(s, temp);
									t[i][j].get(s).z++;
								}
								// 양분을 먹지 못할 경우 나무 죽음
								else {
									Tree temp = new Tree(age, false);
//									t[i][j].set(s, temp);
									t[i][j].get(s).alive = false;
								}
							}
						}
//						System.out.println(k + " to2 좌표 : " + i + " " + j + " " + t[i][j].toString());
					}
				}
			}
			// 여름
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (t[i][j].size() > 0) {
						for (int s = 0; s < t[i][j].size(); s++) {
							// 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
							if (t[i][j].get(s).alive == false) {
								map[i][j] += t[i][j].get(s).z / 2;
								t[i][j].remove(s);
								s--;
							}
						}
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(t[i][j].size()>0) {
//						for (int s = 0; s < t[i][j].size(); s++) {
//							// 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
//							if(t[i][j].get(s).alive == false) {
//								t[i][j].remove(s);
//								s--;
//							}
//						}
//					}
//				}
//			}
			// 가을
			Queue<Tree> q = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int s = 0; s < t[i][j].size(); s++) {
						if (t[i][j].get(s).alive == true) {
							q.offer(new Tree(i, j, t[i][j].get(s).z));
						}
					}
				}
			}

//			System.out.println(q.toString());

			while (!q.isEmpty()) {
				Tree tree = q.poll();
				// 번식하는 나무는 나이가 5의 배수이어야 하며
				if (tree.z % 5 == 0) {
					// 인접한 8개의 칸에 나이가 1인 나무가 생긴다
					for (int d = 0; d < 8; d++) {
						int nx = tree.x + delta[d][0];
						int ny = tree.y + delta[d][1];
						if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
							t[nx][ny].add(0, new Tree(1));
						}
					}
				}
			}

			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += A[i][j];
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(t[i][j].size() + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			k++;

			if (k == K) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						for (int s = 0; s < t[i][j].size(); s++) {
							if (t[i][j].get(s).alive == true) {
								ans++;
							}
						}
					}
				}
				return;
			}
		}
	}

}
