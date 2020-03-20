package array;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate extends BaseArray {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};

        ContainsDuplicate obj = new ContainsDuplicate();
        boolean isDuplicate = obj.containsDuplicate3(nums);

        System.out.println("isDuplicate:" + isDuplicate);
    }

    // 提交没通过，提示超出时间限制，这个时间复杂度是O(n*n)
    private boolean containsDuplicate(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }

        return false;

    }

    // 使用系统的排序通过了，系统的排序最快应该也是O(nlogn)，加上一次比较的时间O(n)，所以这个时间复杂度是O(nlogn+n)
    private boolean containsDuplicate2(int[] nums) {
        // 自己使用快排提交没通过，提示超出时间限制，用系统的排序就过了...，难道自己写的快排不好用么
        java.util.Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0)
                return true;
        }

        return false;

    }

    // 提交通过，这种就是Set添加查找是否存在的时间了，都是O(1)，所以这个时间复杂度是O(n)
    private boolean containsDuplicate3(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }

        return false;

    }
}
