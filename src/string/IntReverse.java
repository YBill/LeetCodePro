package string;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 注意整形的范围是 [−2^31,  2^31 − 1]，翻转后可能会越界，越界返回0
 */
public class IntReverse {

    public static void main(String[] args) {
        int num = -100;

        IntReverse obj = new IntReverse();
        int result = obj.reverse2(num);

        System.out.println(result);

        System.out.println((-123 / 10));
    }

    public int reverse2(int x) {
        int term;
        long result = 0; // 用long存放，否则翻转后可能会越界
        while (x != 0) {
            // 下面两句分别取出每一位数字
            term = x % 10;
            x = x / 10;

            // 将每一位数放到新的位置，没新加一位数，之前数字位数提升一个(乘10)
            result = result * 10 + term;
        }

        // 越界后返回0
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    // 将整数拆分后放到字符串中
    public int reverse(int x) {
        int length = String.valueOf(x).length();

        boolean isNegative = false;
        if (x < 0) {
            length--;
            x = -x;
            isNegative = true;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = x % 10;
            x /= 10;
            builder.append(num);
        }

        int newNum = 0;
        // 根据题目要求，整形越界了直接返回0，这里直接捕获异常了
        try {
            newNum = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }

        if (isNegative)
            newNum = -newNum;

        return newNum;
    }

}
