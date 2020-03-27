package string;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "ac";
        String t = "bb";

        IsAnagram obj = new IsAnagram();
        boolean isAnagram = obj.isAnagram(s, t);

        System.out.println("isAnagram:" + isAnagram);
    }

    public boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        if (sLength != tLength)
            return false;

        int[] nums = new int[26];
        for (int i = 0; i < sLength; i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
