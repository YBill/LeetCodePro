package array;

import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 3, 2};

        SingleNumber obj = new SingleNumber();
        int num = obj.singleNumber2(nums);

        System.out.println("num:" + num);

    }

    // 这个问题比较常规的方法就是排序后再依次比较响铃两个或者是通过Map记录每个数字出现的数字
    // singleNumber2 方法是看别人提交执行时间最少的，研究一下果然碉堡了

    private int singleNumber(int[] nums) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }

        int num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                num = entry.getKey();
                break;
            }
        }

        return num;
    }

    /**
     * 位异或( ^ )：A^B  转化为二进制，如果相对应相同则为0，不同为1。根据概念可以得出下面结论：
     * 1、A^0=A(一个数和0算结果就是这个数本身)
     * 2、A^A=0(一个数和本事算结果是0)
     * 3、位异或( ^ )符合交换律和结合律
     * <p>
     * 所有这个问题就简单了，只要重复的出现偶数次，依次取位异或( ^ )，并相加，通过交换律和结合律合并一下，最后剩下的就是那个不一样的了。
     */
    private int singleNumber2(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total ^= nums[i];
        }
        return total;
    }

}
