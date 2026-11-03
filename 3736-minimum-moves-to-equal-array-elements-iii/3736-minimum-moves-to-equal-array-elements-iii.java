class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        for(int i:nums){
            if(i!=max){
                c=c+(max-i);
            }
        }
        return c;
    }
}