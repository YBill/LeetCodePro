package other;

/**
 * 缺失数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 */
public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = new int[]{3, 0, 1};
        System.out.println(missingNumber.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int length = nums.length;
        // 将nums中所有数相加
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        // 根据等差数列求和公式求本来0～length中相加的数
        int s = (1 + length) * length / 2;
        // 用不缺数是相加的结果减去缺少的，就是缺的那个数
        return s - sum;

    }

}
