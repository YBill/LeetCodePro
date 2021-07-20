package other;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class HammingWeight {

    // JDK 自带的方法
    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * n & (n−1) 就是把 n 的二进制位中的最低位的 1 变为 0 之后的结果
     * 如 6 & (6-1) -> 0110 & 0101 = 0100，可以看到相当于把6即0110最低位的1变成了0即变成了0100
     * 然后就这样一直处理下去，最终都会变成0
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

}

