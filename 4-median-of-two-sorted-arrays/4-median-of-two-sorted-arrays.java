class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int low = 0, high = n1;
        
        while(low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (n1 + n2 + 1) / 2 - partitionX;
            
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == n1 ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == n2 ? Integer.MAX_VALUE : nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((n1 + n2) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0.0;
    }
}