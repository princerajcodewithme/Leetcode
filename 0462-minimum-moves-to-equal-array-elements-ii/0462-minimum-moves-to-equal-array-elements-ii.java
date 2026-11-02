class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median=0;
        int c=0;
        if(nums.length%2==0){
            median=nums.length/2;
        }
        else{
            median=(nums.length-1)/2;
        }
        int el=nums[median];
        for(int i=0;i<nums.length;i++){
            if(i==median){
                continue;
            }
            else{
                int diff=nums[i]-el;
                if(diff<0){
                    diff=diff*-1;
                    c=c+diff;
                }
                else{
                    c=c+diff;
                }
            }
        }
        return c;
    }
}