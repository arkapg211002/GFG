//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		
out.println("~");
}
		out.close();
	}
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    // Directions to move in the grid (up, down, left, right)
     int[] dx = {0, 0, 1, -1};
     int[] dy = {1, -1, 0, 0};

    // BFS function to mark reachable cells
    public  void bfs(Queue<int[]> queue, boolean[][] reachable, int[][] mat, int N, int M) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Explore 4 possible directions
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // Check bounds and if the next cell can be reached
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !reachable[nx][ny] && mat[nx][ny] >= mat[x][y]) {
                    reachable[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
	int water_flow(int [][] mat, int N, int M) {
		//Write your code here
		
        // Two visited arrays to track reachable cells for Indian Ocean and Arabian Sea
        boolean[][] indian = new boolean[N][M];
        boolean[][] arabian = new boolean[N][M];

        // Queues for BFS for Indian Ocean (top and left edges) and Arabian Sea (bottom and right edges)
        Queue<int[]> indianQueue = new LinkedList<>();
        Queue<int[]> arabianQueue = new LinkedList<>();

        // Initialize queues with the border cells
        for (int i = 0; i < N; i++) {
            // Left border for Indian Ocean
            indianQueue.offer(new int[] {i, 0});
            indian[i][0] = true;

            // Right border for Arabian Sea
            arabianQueue.offer(new int[] {i, M - 1});
            arabian[i][M - 1] = true;
        }

        for (int j = 0; j < M; j++) {
            // Top border for Indian Ocean
            indianQueue.offer(new int[] {0, j});
            indian[0][j] = true;

            // Bottom border for Arabian Sea
            arabianQueue.offer(new int[] {N - 1, j});
            arabian[N - 1][j] = true;
        }

        // Perform BFS for Indian Ocean and Arabian Sea
        bfs(indianQueue, indian, mat, N, M);
        bfs(arabianQueue, arabian, mat, N, M);

        // Count cells that can reach both oceans
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (indian[i][j] && arabian[i][j]) {
                    count++;
                }
            }
        }

        return count;
	}
}