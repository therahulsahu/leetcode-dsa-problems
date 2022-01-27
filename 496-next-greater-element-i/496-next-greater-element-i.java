class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = nums2.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                hm.put(nums2[i], -1);
            } else if(stack.peek() > nums2[i]) {
                hm.put(nums2[i], stack.peek());
            } else {
                while(stack.size() > 0 && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                
                if(stack.size() > 0) {
                    hm.put(nums2[i], stack.peek());
                } else {
                    hm.put(nums2[i], -1);
                }
            }
            stack.push(nums2[i]);
        }
        
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            result[i] = hm.get(nums1[i]);
        }
        return result;
    }
}