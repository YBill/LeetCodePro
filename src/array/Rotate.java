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
        obj.rotate2(nums, 2);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * @param nums
     * @param k
     */
    private void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int end = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = end;
        }
    }

    // k % length，防止循环无效处理
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

}
