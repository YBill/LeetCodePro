package array;

import java.util.Arrays;

/**
 * 旋转数组：
 * eg: num = [a,b,c,d]
 * rotate[num. 2] ->
 * 第1步: num = [d,a,b,c]
 * 第2步: num = [c,d,a,b]
 */
public class Rotate {

    public static void main(String[] args) {
        int nums[] = {-1, -100, 3, 99};

        Rotate obj = new Rotate();
        obj.rotate3(nums, 2);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 借助一个新数组完成，时间复杂度O(n)
     *
     * @param nums
     * @param k
     */
    private void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        int[] newNums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[(length - k + i) % length];
        }
        for (int i = 0; i < newNums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    /**
     * 执行k次旋转，时间复杂度O(kn)
     *
     * @param nums
     * @param k
     */
    private void rotate2(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < k % length; i++) {
            int end = nums[length - 1];
            for (int j = length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = end;
        }
    }

    /**
     * 反转数组，时间复杂度O(n)
     *
     * @param nums
     * @param k
     */
    private void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); // 先反转全部
        reverse(nums, 0, k - 1); // 再反转前k个
        reverse(nums, k, nums.length - 1); // 最后反转剩下的
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
