class Solution {
    public int findKthPositive(int[] arr, int k) {
        // binary search
        
        int start = 0, end = arr.length, mid;
        
        while(start < end) {
            mid = start + (end - start) / 2;
            if(arr[mid] - (mid + 1) >= k) {
                end =  mid;
            } else {
                start = mid + 1;
            }
        }
        return start + k;
    }
}