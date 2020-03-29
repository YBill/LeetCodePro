package string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};

        LongestCommonPrefix obj = new LongestCommonPrefix();
        String str = obj.longestCommonPrefix(strs);

        System.out.println(str);
    }


    public String longestCommonPrefix(String[] strs) {
        int strLength = strs.length;
        if (strLength == 0)
            return "";

        int length = strs[0].length();

        StringBuilder builder = new StringBuilder();

        for (int j = 0; j < length; j++) {
            if (j >= strs[0].length())
                break;
            char c = strs[0].charAt(j);
            int num = 0;
            for (int i = 1; i < strLength; i++) {
                String str = strs[i];
                if (j >= str.length())
                    break;
                if (c == str.charAt(j)) {
                    num++;
                }
            }
            if (num == strLength - 1)
                builder.append(c);
            else break;
        }


        return builder.toString();

    }
}
