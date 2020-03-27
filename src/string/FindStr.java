package string;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 输入: haystack = "aaaaa", needle = ""
 * 输出: 0
 */
public class FindStr {

    public static void main(String[] args) {
        String haystack = "a", needle = "";
        FindStr obj = new FindStr();
        int index = obj.strStr(haystack, needle);

        System.out.println(index);
    }

    public int strStr(String haystack, String needle) {
        char[] hChar = haystack.toCharArray();
        char[] nChar = needle.toCharArray();

        int hLength = hChar.length;
        int nLength = nChar.length;

        if (nLength == 0)
            return 0;
        if (hLength < nLength)
            return -1;

        int index = 0; // needle的下标
        for (int i = 0; i < hLength; i++) { // i haystack的下标
            if (hChar[i] == nChar[index]) {
                index++;
            } else {
                if (index > 0) {
                    i = i - index; // 开始匹配后面不匹配，退回到下一个重新匹配
                    index = 0;
                }
            }

            if (index == nLength) {
                return i - index + 1;
            }
        }

        return -1;
    }

}
