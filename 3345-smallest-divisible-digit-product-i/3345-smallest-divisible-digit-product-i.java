class Solution {
    public int smallestNumber(int n, int t) {
        if(n%10==0){
            return n;
        }
        int ans=0;
        for(int i=n;i<n+10;i++){
            int p=1;
            if(i%10==0){
                return i;
            }
            int d=0,temp=i;
            while(temp!=0){
                d=temp%10;
                p=p*d;
                temp=temp/10;
            }
            if(p%t==0){
                ans=i;
                break;
            }
        }
        return ans;
    }
}