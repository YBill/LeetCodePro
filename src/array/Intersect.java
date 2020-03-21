package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 求出两个数组的交集
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 */
public class Intersect {

    public static void main(String[] args) {
        int nums1[] = {2, 1};
        int nums2[] = {1, 2};

        Intersect obj = new Intersect();
        int[] num = obj.intersect2(nums1, nums2);

        System.out.println(Arrays.toString(num));

    }

    private int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        java.util.List<Integer> list2 = new ArrayList<>(length2);
        for (int i = 0; i < length2; i++) {
            list2.add(nums2[i]);
        }

        java.util.List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (nums1[i] == list2.get(j)) {
                    list.add(list2.remove(j));
                    break;
                }
            }
        }

        int[] num = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(i);
        }

        return num;
    }

    // 排序后因为有序了，比较不同后就可以向后移动了，因为前面的不会再比较了
    private int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0, indexValue = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                nums1[indexValue] = nums1[index1];
                index1++;
                index2++;
                indexValue++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, indexValue);
    }

}
