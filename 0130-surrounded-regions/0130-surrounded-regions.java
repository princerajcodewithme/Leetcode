class Solution {
    int m;
    int n;
    int flag = 1;

    private void bfs(char[][] board, int[][] vis, int i, int j, ArrayList<int[]> list) {

        vis[i][j] = 1;
        list.add(new int[]{i, j});

        // boundary O mila
        if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
            flag = 0;
        }

        if(i + 1 < m && board[i + 1][j] == 'O' && vis[i + 1][j] == 0)
            bfs(board, vis, i + 1, j, list);

        if(i - 1 >= 0 && board[i - 1][j] == 'O' && vis[i - 1][j] == 0)
            bfs(board, vis, i - 1, j, list);

        if(j + 1 < n && board[i][j + 1] == 'O' && vis[i][j + 1] == 0)
            bfs(board, vis, i, j + 1, list);

        if(j - 1 >= 0 && board[i][j - 1] == 'O' && vis[i][j - 1] == 0)
            bfs(board, vis, i, j - 1, list);
    }

    public void solve(char[][] board) {

        m = board.length;
        n = board[0].length;

        int[][] vis = new int[m][n];

        for(int i = 1; i < m - 1; i++){
            for(int j = 1; j < n - 1; j++){

                if(board[i][j] == 'O' && vis[i][j] == 0){

                    flag = 1;
                    ArrayList<int[]> list = new ArrayList<>();

                    bfs(board, vis, i, j, list);

                    if(flag == 1){
                        for(int[] ar : list){
                            board[ar[0]][ar[1]] = 'X';
                        }
                    }
                }
            }
        }
    }
}