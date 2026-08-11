class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                sum=sum+nums[i];
            }
            else{
                break;
            }
        }
        Arrays.sort(nums);
        int eqp=0,j=1,ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==sum){
                eqp=1;
            }
            if(nums[i]>sum){
                if(eqp==0) break;
                else if(nums[i]==nums[i-1]){
                    continue;
                }
                else{
                    if(sum+j!=nums[i]){
                        ans=sum+j;
                        break;
                    }
                    j++;
                }
            }

        }
        if(eqp==0 || nums[nums.length-1]<sum){
            return sum;
        }
        if(ans==0){
            return nums[nums.length-1]+1;
        }
        return ans;
    }
}