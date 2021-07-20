package other;

/**
 * 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：看下面二进制后不同
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 */
public class HammingDistance {

    /**
     * ^ 操作是对应的二进制位数相同则为0，不同则为1
     * 所以 x ^ y 后的结果不同的位数都变成1了，然后再利用HammingWeight中找位1的数量的方式就可以找出不同
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }

}
