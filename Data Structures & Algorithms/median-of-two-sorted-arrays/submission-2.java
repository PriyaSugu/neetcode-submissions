class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = (total + 1)/2;
        int[] A = m < n ? nums1 : nums2;
        int[] B = m < n? nums2 : nums1;

        int l = 0, r = A.length;

        while(l <= r){
            int i = l + (r-l)/2;
            int j = half - i;

            int Aleft = i > 0? A[i-1] : Integer.MIN_VALUE;
            int Aright = i < A.length? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length? B[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                }else{
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
            }else if(Aleft > Bright){
                r = i - 1;
            }else{
                l = i + 1;
            }
        }

        return -1;
    }
}
