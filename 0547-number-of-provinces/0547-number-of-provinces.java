class Solution {
    int[] vis;
    private void dfs(int[][] arr1,int[] vis,int index){
        int[] arr=arr1[index];
        for(int j=0;j<arr.length;j++){
            if(vis[j]==0 && arr1[index][j]==1){
                vis[j]=1;
                dfs(arr1,vis,j);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int c=0;
        int l=isConnected.length;
        vis=new int[isConnected.length];
        for(int i=0;i<l;i++){
            if(vis[i]==0){
                c++;
                vis[i]=1;
                dfs(isConnected,vis,i);
            }
        }
        return c;
    }
}