package Shibing;

public class Code02_SearchForTheMiddleNumber {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int[] n3 = new int[nums1.length + nums2.length];
//         int start1 = 0, int start2 = 0;
//         for (int i = 0; i < n3.length; i++) {
//             if (start1 < nums1.length && start2 < nums2.length)
//                 n3[i] = nums1[start1++];
//             else 
//                 n3[i] = nums2[start2++];
//         else {
//             if (start1 < nums1.length) 
//                 n3[i] = nums1[start1++];
//             else
//                 n3[i] = nums2[start2++];
//         }
//     }
//     if (n3.length % 2 == 0) 
//         return (n3[(n3.length/2)] + n3[(n3.length/2-1)])/2.0;
//     else 
//         return n3[(n3.length/2)];
//     }
// }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = n1 + n2;
        int[] nums = new int[n3];
        int left = 0, right = 0;
        int i;
        for(i = 0; i < n3; i++) {
            if(left < n1 && right < n2) {
                if(nums1[left] < nums2[right]) {
                    nums[i] = nums1[left];
                    left ++;
                } else {
                    nums[i] = nums2[right];
                    right ++;
                }
            } else {
                break;
            }
        }

        while(left < n1) {
            nums[i] = nums1[left];
            i++;
            left++;
        }

        while(right < n2) {
            nums[i] = nums2[right];
            i++;
            right++;
        }

        return n3 % 2 == 0? (((double)nums[n3/2 - 1] + (double)nums[n3/2]) / 2) : nums[n3/2];

    }

}
