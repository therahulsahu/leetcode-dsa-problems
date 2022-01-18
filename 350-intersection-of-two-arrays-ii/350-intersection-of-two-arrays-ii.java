class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n: nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int n: nums2) {
            if(map.containsKey(n)) {
                arrayList.add(n);
                map.put(n, map.get(n) - 1);
                map.remove(n, 0); // removes key n only if value is 0
            }
        }
        
        int[] result = new int[arrayList.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}