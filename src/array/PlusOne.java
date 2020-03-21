package array;

import java.util.Arrays;

/**
 * 加一，给定一个数组，这个数组代表一个数字，结果是这个数加一；难点就是进位的时候数组要扩容
 * 输入: [1,2,3]   [9,9]
 * 输出: [1,2,4]   [1,0,0]
 */
public class PlusOne {
    public static void main(String[] args) {

        int nums[] = {9, 1, 9};

        PlusOne obj = new PlusOne();
        int[] num = obj.plusOne3(nums);

        System.out.println(Arrays.toString(num));

    }

    private int[] plusOne(int[] digits) {
        int length = digits.length;

        return plus(digits, length - 1);
    }

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
}
