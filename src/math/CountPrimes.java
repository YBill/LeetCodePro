package math;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();

        final int n = 10000;
        int result = countPrimes.countPrimes2(n);
        System.out.println(result);

    }

    // 厄拉多塞筛法
    public int countPrimes3(int n) {
        int[] isPrime = new int[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 0) {
                sum++;
                // 这里优化一下，不是直接从j=2i开始，因为2i,3i这些在最开始几个就已经被标记过了
                // 所以直接从j=i*i开始
                // 不过i*i可能会超出int范围，然后强转int会变成负数，所以需要判断一下
                if ((long) i * i >= n)
                    continue;
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 1;
                }
            }
        }
        return sum;
    }

    /**
     * 厄拉多塞筛法
     * isPrime[i]为0表示质数，sPrime[i]为1表示合数，起始都设为质数，
     * 然后拿出一个质素，则他的所有倍数都是合数，以此往后
     */
    public int countPrimes2(int n) {
        byte[] isPrime = new byte[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 0) {
                sum++;
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = 1;
                }
            }
        }
        return sum;
    }

    public int countPrimes(int n) {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes3(i)) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 对isPrimes1进行优化
     * 跟isPrimes2一样，不一样的写法
     */
    private boolean isPrimes3(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对isPrimes1进行优化
     * 如果n是合数（除了质数就是合数，能被除1和本身的其他数整除），
     * 则肯定有 x*y=n，所以此时对n开方，得到sqrt(n),肯定有 x<=sqrt(n)&&y>=sqrt(n)
     * 所以就不用遍历到n，只遍历到sqrt(n)即可
     */
    private boolean isPrimes2(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力法
     * 每个数都除以小于他的所有数
     * 这个时间复杂度是O(n)，
     * 再加上外面调用者一层循环，整体O(n*n)了
     */
    private boolean isPrimes1(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这是个错误示例
     * 不能被2，3，5，7整除的数是质数吗？
     * 小于121以内的数，可以说这样是正确的，但是再大了就不行了
     * 比如121=11x11，143=11x13，这两个都不是质数，但是确实不能被2，3，5，7整除
     */
    private boolean isPrimes0(int num) {
        if (num != 2 && num % 2 == 0) {
            return false;
        }
        if (num != 3 && num % 3 == 0) {
            return false;
        }
        if (num != 5 && num % 5 == 0) {
            return false;
        }
        if (num != 7 && num % 7 == 0) {
            return false;
        }
        return true;
    }

}
