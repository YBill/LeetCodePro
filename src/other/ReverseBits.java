package other;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释：其实就是反转了
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // res 先向左移一位
            res <<= 1;
            // 取出n的最低位
            int gw = n & 1;
            // | 是对应的位都是0则取0，只要有1就取1
            // 所以 下面相当于把取出n的最低位放到res的最低位了
            res |= gw;
            // n 向右移一位
            n >>= 1;
        }
        return res;
    }

}
