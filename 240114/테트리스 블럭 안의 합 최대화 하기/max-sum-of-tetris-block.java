import java.util.*;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int N, M, max;
	static int[][] arr;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][M];
		check = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				check[r][c] = true;
				dfs(r, c, 1, arr[r][c]);
				check[r][c] = false;
				tetris(r, c);
			}
		}
		System.out.println(max);
	}
	
	public static void dfs(int r, int c, int cnt, int sum) {
		if(cnt >= 4) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || check[nr][nc]) continue;
			
			check[nr][nc] = true;
			dfs(nr, nc, cnt+1, sum+arr[nr][nc]);
			check[nr][nc] = false;
		}
	}
	
	public static void tetris(int r, int c) {
		if (r > 0 && r < N - 1 && c < M - 1)
	        max = Math.max(max, arr[r][c] + arr[r - 1][c] + arr[r + 1][c] + arr[r][c + 1]);

	    if (r > 0 && r < N - 1 && c > 0)
	        max = Math.max(max, arr[r][c] + arr[r - 1][c] + arr[r + 1][c] + arr[r][c - 1]);

	    if (r < N - 1 && c > 0 && c < M - 1)
	        max = Math.max(max, arr[r][c] + arr[r][c - 1] + arr[r][c + 1] + arr[r + 1][c]);

	    if (r > 0 && c > 0 && c < M - 1)
	        max = Math.max(max, arr[r][c] + arr[r][c - 1] + arr[r][c + 1] + arr[r - 1][c]);
	    }

}