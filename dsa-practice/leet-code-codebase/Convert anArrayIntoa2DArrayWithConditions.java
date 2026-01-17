class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (true) {
            List<Integer> row = new ArrayList<>();
            boolean added = false;

            for (int key : map.keySet()) {
                if (map.get(key) > 0) {
                    row.add(key);
                    map.put(key, map.get(key) - 1);
                    added = true;
                }
            }

            if (!added) break;
            result.add(row);
        }

        return result;
    }
}
