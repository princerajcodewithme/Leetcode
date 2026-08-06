class Solution {
    private void dfs(int i,int j,int[][] image,int org,int color,int[][] vis){
        if(j+1<image[0].length && image[i][j+1]==org && vis[i][j+1]==0){
            image[i][j+1]=color;
            vis[i][j+1]=1;
            dfs(i,j+1,image,org,color,vis);
        }
        if(i+1<image.length && image[i+1][j]==org && vis[i+1][j]==0){
            image[i+1][j]=color;
            vis[i+1][j]=1;
            dfs(i+1,j,image,org,color,vis);
        }
        if(j-1>=0 && image[i][j-1]==org && vis[i][j-1]==0){
            image[i][j-1]=color;
            vis[i][j-1]=1;
            dfs(i,j-1,image,org,color,vis);
        }
        if(i-1>=0 && image[i-1][j]==org && vis[i-1][j]==0){
            image[i-1][j]=color;
            vis[i-1][j]=1;
            dfs(i-1,j,image,org,color,vis);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org=image[sr][sc];
        int[][] vis=new int[image.length][image[0].length];
        image[sr][sc]=color;
        vis[sr][sc]=1;
        dfs(sr,sc,image,org,color,vis);
        return image;
    }
}