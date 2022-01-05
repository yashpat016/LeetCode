class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] merged = new double[nums1.length + nums2.length];
        int p1 = 0, p2 = 0, p = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            merged[p++] = nums1[p1] > nums2[p2] ? nums2[p2++] : nums1[p1++];
        }
        if(p1 >= nums1.length){
            while(p2 < nums2.length){
                merged[p++] = nums2[p2++];
            }
        } else {
            while(p1 < nums1.length){
                merged[p++] = nums1[p1++];
            }
        }
        
        if(p%2 == 0){
            return (merged[(p-1)/2]+merged[(p-1)/2 + 1])/2;
        } else {
            return (merged[(p-1)/2]);
        }
    }
}