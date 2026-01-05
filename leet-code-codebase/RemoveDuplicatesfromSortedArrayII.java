public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int idx = 0;
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[idx]==nums[i]){
                if(count<2){
                idx++;
                nums[idx] = nums[i];
                count++;
                }
            }
            else{
            idx++;
            nums[idx]=nums[i];
            count=1;
            }    
        }
        return idx+1;
    }
}
