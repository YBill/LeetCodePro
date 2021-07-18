package math;

/**
 * 3的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 输入：n = 27
 * 输出：true
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        IsPowerOfThree three = new IsPowerOfThree();
        int n = 19684;
        System.out.println(three.isPowerOfThree3(n));
    }

    /**
     * 1162261467是整型范围内3的最大次幂了，所以3的次幂都可以被他整除
     */
    public boolean isPowerOfThree3(int n) {
        if (n <= 0)
            return false;
        return 1162261467 % n == 0;
    }

    /**
     * 递归
     */
    public boolean isPowerOfThree2(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        if (n % 3 == 0)
            return isPowerOfThree2(n / 3);
        return false;
    }

    /**
     * 暴力法，一直除三
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        while (true) {
            int s = n / 3;
            int y = n % 3;
            if (s == 0 || y != 0) {
                return false;
            }
            if (s == 1) {
                return true;
            }

            n = s;
        }
    }
}
