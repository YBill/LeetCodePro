package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "loveleetcode";

        FirstUniqChar obj = new FirstUniqChar();
        int index = obj.firstUniqChar2(s);

        System.out.println("index:" + index);
    }

    public int firstUniqChar2(String s) {
        int[] temp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (temp[c - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

}
