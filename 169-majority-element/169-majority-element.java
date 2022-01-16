class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int x: nums) {
            if(hm.containsKey(x)) {
                hm.put(x, hm.get(x) + 1);
                if(hm.get(x) > n / 2) {
                    return x;
                }
            } else {
                hm.put(x, 1);
            }
        }
        return nums[0];
    }
}