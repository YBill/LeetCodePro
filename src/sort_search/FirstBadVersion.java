package sort_search;

/**
 * 第一个错误的版本
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 比如版本10是错误的，说明大于10的所以版本都是错误的
 * <p>
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        int n = 2126753390;

        FirstBadVersion obj = new FirstBadVersion();
        int result = obj.firstBadVersion2(n);

        System.out.println(result);
    }

    public int firstBadVersion2(int n) {
        int up = n;
        int bottom = 1;
        while (bottom < up) {
            int mid = (up - bottom) / 2 + bottom;
            if (isBadVersion(mid)) {
                up = mid;
            } else {
                bottom = mid + 1;
            }

        }

        return bottom;
    }

    // 典型的二分法问题,注意取中间数越界问题
    public int firstBadVersion(int n) {
        int up = n;
        int bottom = 1;
        while (true) {
//            int mid = (up + bottom) / 2; // 越界了
            int mid = (up - bottom) / 2 + bottom;
            if (isBadVersion(mid)) {
                up = mid;
            } else {
                bottom = mid + 1;
            }

            if (bottom == up)
                return bottom;
        }
    }

    boolean isBadVersion(int version) {
        if (version >= 1702766719)
            return true;
        return false;
    }
}
