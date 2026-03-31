class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        HashSet<Integer> ans = new HashSet<>();
        for(int i:nums2){
            if(set.contains(i)){
               ans.add(i); 
            }
        }
        int[] k = new int[ans.size()];
        int j=0;
        for(int i:ans){
            k[j++] = i;
        }
        return k;
    }
}
