class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l=nums.length;
        int[] arr=new int[2];
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }
}