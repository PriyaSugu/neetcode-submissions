class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = m + n;
        int half = (total + 1)/ 2;

        int l = 0, r = m;
        
        while(l <= r){
            int m1 = l + (r-l)/2;
            int m2 = half - m1;

            int l1 = m1 == 0? Integer.MIN_VALUE:nums1[m1-1];
            int r1 = m1 == m? Integer.MAX_VALUE:nums1[m1];
            int l2 = m2 == 0? Integer.MIN_VALUE:nums2[m2-1];
            int r2 = m2 == n? Integer.MAX_VALUE:nums2[m2];

            if(l1 <= r2 && l2 <= r1){
                if(total % 2 != 0){
                    return Math.max(l1,l2);
                }else{
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
            }else if(l2 <= r1){
                r = m1 - 1;
            }else{
                l = m1 + 1;
            }
        }
        return 0;
    }
}
