package string;

/**
 * 字符串转换整数 (atoi)
 * <p>
 * 输入: "42"
 * 输出: 42
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 */
public class MyAtoi {

    public static void main(String[] args) {
        String str = "9223372036854775808";
        MyAtoi obj = new MyAtoi();
        int num = obj.myAtoi2(str);

        System.out.println(num);
    }

    // 通过整型承接最后结果，承接前先判断是否会越界
    public int myAtoi3(String str) {
        char[] myChar = str.toCharArray();

        int length = myChar.length;

        if (length == 0)
            return 0;

        int startIndex = 0;

        while (startIndex < length && myChar[startIndex] == ' ')
            startIndex++;

        int sign = 1;

        if (startIndex < length) {
            if (myChar[startIndex] == '-') {
                startIndex++;
                sign = -1;
            } else if (myChar[startIndex] == '+') {
                startIndex++;
            }
        }

        int total = 0;

        while (startIndex < length) {
            int num = myChar[startIndex] - '0';
            if (num >= 0 && num <= 9) {
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                total = 10 * total + num;
                startIndex++;
                continue;
            }
            break;
        }

        total = total * sign;

        return total;
    }

    // 通过double承接最后数字，long也越界了
    public int myAtoi2(String str) {
        char[] myChar = str.toCharArray();

        int length = myChar.length;

        if (length == 0)
            return 0;

        int startIndex = 0;

        while (startIndex < length && myChar[startIndex] == ' ')
            startIndex++;

        int sign = 1;

        if (startIndex < length) {
            if (myChar[startIndex] == '-') {
                startIndex++;
                sign = -1;
            } else if (myChar[startIndex] == '+') {
                startIndex++;
            }
        }

        double total = 0;

        while (startIndex < length) {
            int num = myChar[startIndex] - '0';
            if (num >= 0 && num <= 9) {
                total = 10 * total + num;
                startIndex++;
                continue;
            }
            break;
        }

        total = total * sign;

        if (total > Integer.MAX_VALUE)
            total = Integer.MAX_VALUE;
        else if (total < Integer.MIN_VALUE)
            total = Integer.MIN_VALUE;

        return (int) total;
    }

    // 通过字符串拼接最后数字
    public int myAtoi(String str) {
        char[] myChar = str.toCharArray();

        int length = myChar.length;

        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            if (myChar[i] == ' ') {
                startIndex++;
                continue;
            }
            break;
        }

        StringBuilder builder = new StringBuilder();

        if (startIndex < length) {
            if (myChar[startIndex] == '-') {
                startIndex++;
                builder.append("-");
            } else if (myChar[startIndex] == '+') {
                startIndex++;
            }
        }

        builder.append("0");

        for (int i = startIndex; i < myChar.length; i++) {
            if (isNum(myChar[i])) {
                builder.append(myChar[i]);
                continue;
            }
            break;
        }

        double result = Double.parseDouble(builder.toString());

        if (result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;

        return (int) result;
    }

    private boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }

}
