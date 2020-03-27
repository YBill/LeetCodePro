package string;

/**
 * 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        CountAndSay obj = new CountAndSay();
        String str = obj.countAndSay(n);

        System.out.println(str);
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return say(countAndSay(--n));
    }

    private String say(String str) {
        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();
        char start = chars[0];
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if (start == chars[i]) {
                count++;
            } else {
                builder.append(count + 1);
                builder.append(start);
                count = 0;
                start = chars[i];
            }
        }

        builder.append(count + 1);
        builder.append(start);

        return builder.toString();
    }


}
