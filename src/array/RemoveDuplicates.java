package array;

public class RemoveDuplicates extends BaseArray {

    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        RemoveDuplicates obj = new RemoveDuplicates();
        int length = obj.removeDuplicates(nums);

        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    /**
     * 对一个已经有序的数组处理，处理后返回一个整数length，这个整数length表示数组中不重复数的个数，
     * 并且数组前length个数为有序不重复的数，后面的数不用处理。
     * 要求：原地，时间复杂度O(1)
     *
     * @param nums
     * @return length
     */
    private int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            nums[len++] = nums[i];
        }
        return len;
    }

}
