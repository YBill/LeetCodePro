package string;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        IsPalindrome obj = new IsPalindrome();
        boolean result = obj.isPalindrome2(s);

        System.out.println("result:" + result);
    }

    public boolean isPalindrome2(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length - 1;

        while (left <= right) {

            if (!isValidChar(str[left])) {
                left++;
                continue;
            }

            if (!isValidChar(str[right])) {
                right--;
                continue;
            }

            // 转化为大写或小写，数字不会转化
            if (Character.toUpperCase(str[left++]) != Character.toUpperCase(str[right--])) {
                return false;
            }

        }

        return true;
    }

    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();

        int length = str.length;

        if (length == 0)
            return true;

        int left = 0;
        int right = length - 1;
        while (left <= right) {

            while (left < length) {
                boolean isValidChar = isValidChar(str[left]);
                if (!isValidChar) {
                    left++;
                } else
                    break;
            }

            while (right > 0) {
                boolean isValidChar = isValidChar(str[right]);
                if (!isValidChar) {
                    right--;
                } else
                    break;
            }

            if (left <= right) {
                if (Character.toUpperCase(str[left]) != Character.toUpperCase(str[right])) {
                    return false;
                }
            }

            left++;
            right--;

        }

        return true;
    }

    private boolean isValidChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (c >= 'A' && c <= 'Z') {
            return true;
        }

        if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }


}
