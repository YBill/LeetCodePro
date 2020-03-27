package string;

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
