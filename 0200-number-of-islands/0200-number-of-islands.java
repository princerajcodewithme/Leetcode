class Solution {
    int[][] vis;
    private void dfs(int i,int j,char[][] grid,int[][] vis){
        if(j+1<grid[0].length && grid[i][j+1]=='1' && vis[i][j+1]==0){
            vis[i][j+1]=1;
            dfs(i,j+1,grid,vis);
        }
        if(i+1<grid.length && grid[i+1][j]=='1' && vis[i+1][j]==0){
            vis[i+1][j]=1;
            dfs(i+1,j,grid,vis);
        }
        if(j-1>=0 && grid[i][j-1]=='1' && vis[i][j-1]==0){
            vis[i][j-1]=1;
            dfs(i,j-1,grid,vis);
        }
        if(i-1>=0 && grid[i-1][j]=='1' && vis[i-1][j]==0){
            vis[i-1][j]=1;
            dfs(i-1,j,grid,vis);
        }
    }
    public int numIslands(char[][] grid) {
        int c=0;
        vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    if(vis[i][j]==0){
                        c++;
                        vis[i][j]=1;
                        dfs(i,j,grid,vis);
                    }
                }
            }
        }
        return c;
    }
}