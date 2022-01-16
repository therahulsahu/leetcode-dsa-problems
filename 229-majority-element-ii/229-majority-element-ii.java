class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boyce-moore majority vote algorithm
        
        int major1 = 0, major2 = 0, count1 = 0, count2 = 0;
        int len = nums.length;
        
        for(int n: nums) {
            if(major1 == n) {
                count1++;
            } else if(major2 == n) {
                count2++;
            } else if(count1 == 0) {
                major1 = n;
                count1++;
            } else if(count2 == 0) {
                major2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        List<Integer> result = new ArrayList<>();
        for(int n: nums) {
            if(n == major1) {
                count1++;
            } else if(n == major2) {
                count2++;
            }
        }
        
        if(count1 > len / 3) result.add(major1);
        if(count2 > len / 3) result.add(major2);
        
        return result;
    }
}