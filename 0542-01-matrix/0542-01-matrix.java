/*class Solution {
    int m;
    int n;

    private int bfs(int[][] mat, int i, int j) {
        Queue<int[]> qu = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        qu.offer(new int[]{i, j});
        vis[i][j] = true;

        int itr = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int k = 0; k < size; k++) {
                int[] arr = qu.poll();
                int a = arr[0];
                int b = arr[1];

                if (mat[a][b] == 0) {
                    return itr;
                }

                if (a + 1 < m && !vis[a + 1][b]) {
                    vis[a + 1][b] = true;
                    qu.offer(new int[]{a + 1, b});
                }

                if (b + 1 < n && !vis[a][b + 1]) {
                    vis[a][b + 1] = true;
                    qu.offer(new int[]{a, b + 1});
                }

                if (a - 1 >= 0 && !vis[a - 1][b]) {
                    vis[a - 1][b] = true;
                    qu.offer(new int[]{a - 1, b});
                }

                if (b - 1 >= 0 && !vis[a][b - 1]) {
                    vis[a][b - 1] = true;
                    qu.offer(new int[]{a, b - 1});
                }
            }

            itr++;
        }

        return itr;
    }

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    ans[i][j] = bfs(mat, i, j);
                }
            }
        }

        return ans;
    }
}*/

class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
}