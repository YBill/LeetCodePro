package sort_search;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 * 1、初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 2、你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
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

    // 这个是别人提交的，因为nums1的大小能放下nums2，所以都不需要临时数组，直接将nums2中大的数据或nums1中大的数据
    // 直接放到nums1后面的位置，nums2都放完则就放好了，没放完最后循环再将nums2中的数据再放到nums1中
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[i + j + 1] = nums2[j--];
            } else {
                nums1[i + j + 1] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
    }

    // 这个比较直观，跟归并排序归并方法原理一样，需要创建一个临时数组
    // 因为之前就是有序的，所以按从大到小依次放到新数组，最后再将剩下的都放进去就可以了
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
