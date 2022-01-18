class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        // two set soln
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        for(int n: nums1)
            set1.add(n);
        
        for(int n: nums2)
            set2.add(n);
        
        if(set1.size() > set2.size())
            return setIntersection(set1, set2);
        else
            return setIntersection(set2, set1);
    }
    
    int[] setIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] result = new int[set1.size()];
        int i = 0;
        
        for(int n: set1)
            if(set2.contains(n)) {
                result[i++] = n;
            }
        
        return Arrays.copyOf(result, i);
    }
}