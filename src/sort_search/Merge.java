package sort_search;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;

        Merge obj = new Merge();
        obj.merge2(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[i + j + 1] = B[j--];
            } else {
                A[i + j + 1] = A[i--];
            }
            System.out.println(Arrays.toString(A));
        }
        while (j >= 0) {
            A[j] = B[j--];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }

        int left = 0;
        int right = 0;
        int index = 0;

        while (left < m && right < n) {
            if (nums[left] < nums2[right]) {
                nums1[index] = nums[left];
                left++;
            } else {
                nums1[index] = nums2[right];
                right++;
            }
            index++;
        }

        for (int i = left; i < m; i++) {
            nums1[index] = nums[i];
            index++;
        }

        for (int i = right; i < n; i++) {
            nums1[index] = nums2[i];
            index++;
        }


    }
}
