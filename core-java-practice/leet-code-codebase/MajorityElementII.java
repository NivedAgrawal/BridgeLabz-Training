class Solution {
    public List<Integer> majorityElement(int[] nums) {
      Arrays.sort(nums);
      int len = nums.length;
      int freq = len/3;
      int count = 1;
      List<Integer> list = new ArrayList<>();
      for(int i=1;i<len;i++){
        if(nums[i-1]==nums[i]){
            count++;
        }
        else{
            if(count>freq){
            list.add(nums[i-1]);
            }
             count = 1;
        }
      }
      if(count>freq){
        list.add(nums[len-1]);
      }
      return list;
    }
}
