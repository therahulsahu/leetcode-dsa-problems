class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        while(k >= arr[i]) {
            k++;
            i++;
            if(i == arr.length){
                break;
            }
        }
        return k;
    }
}