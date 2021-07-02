package array;

import java.util.Arrays;

/**
 * 加一，给定一个数组，这个数组代表一个数字，结果是这个数加一；难点就是进位的时候数组要扩容
 * 输入: [1,2,3]   [9,9]
 * 输出: [1,2,4]   [1,0,0]
 */

/**
 * 思路：因为需要扩容的都是比如 9,99,999 这种的，所以扩容后就就是第一位是1，后面都是0
 */
public class PlusOne {
    public static void main(String[] args) {

        int nums[] = {9, 9};

        PlusOne obj = new PlusOne();
        int[] num = obj.plusOne2(nums);

        System.out.println(Arrays.toString(num));

    }

    private int[] plusOne(int[] digits) {
        int length = digits.length;
        return plus(digits, length - 1);
    }

    // 递归
    private int[] plus(int[] num, int i) {
        if (num[i] < 9) {
            num[i] = num[i] + 1;
            return num;
        }
        num[i--] = 0;

        if (i < 0) {
            int[] newNum = new int[num.length + 1];
//            System.arraycopy(num, 0, newNum, 1, num.length);
            newNum[0] = 1;
            return newNum;
        }

        return plus(num, i);
    }

    private int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    private int[] plusOne3(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 这种实现想法还行，时间复杂度很小，因为是用的数组位数
     * 但数组太大后 long 都放不下。。。
     * 所以这种方式不行
     *
     * @param digits
     * @return
     */
    private int[] plusOne4(int[] digits) {

        long data = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            data += digits[i] * pf(length - i);
        }

        data += 1;

        int numLength = numLength(data);
        int[] newNums = new int[numLength];

        for (int i = 0; i < numLength; i++) {
            newNums[i] = (int) (data / pf(numLength - i) % 10);
        }

        return newNums;
    }

    // 求整数位数的
    private int numLength(long data) {
        int length = 0;
        for (long i = data; i != 0; i /= 10) {
            length++;
        }
        return length;
    }

    // 求平方的
    private long pf(int length) {
        long data = 1;
        for (int i = 1; i < length; i++) {
            data *= 10;
        }
        return data;
    }

    /**
     * 通过没问题
     *
     * @param digits
     * @return
     */
    private int[] plusOne5(int[] digits) {
        int length = digits.length;
        return realPlus(digits, length - 1);
    }

    // 跟plus一样基本，不同时间写的一样的思路，不同的写法
    private int[] realPlus(int[] digits, int index) {
        if (index < 0) {
            int[] newNums = new int[digits.length + 1];
            newNums[0] = 1;
            // 不需要下面逻辑了，因为后面都是0了
//            for (int i = 1; i < digits.length; i++) {
//                newNums[i] = digits[i];
//            }
            return newNums;
        }

        if (digits[index] < 9) {
            digits[index] += 1;
            return digits;
        }

        digits[index] = 0;

        return realPlus(digits, index - 1);
    }

}
