class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int len = strs.length;
        int k = 0;
        for(int i=0;i<len;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sub = new String(arr);
            if(!map.containsKey(sub)){
                map.put(sub,k++);
                List<String> subl = new ArrayList<>();
                subl.add(strs[i]);
                list.add(subl);
            }
            else{
                int idx = map.get(sub);
                list.get(idx).add(strs[i]);
            }
        }
        return list;
    }
}
