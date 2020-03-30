package dynamic_programming;

/**
 * 买卖股票的最佳时机 （只可以买卖一次）
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};

        MaxProfit obj = new MaxProfit();
        int result = obj.maxProfit2(nums);

        System.out.println(result);
    }

    // 分治算法思想，一次遍历，时间复杂度O(n)
    public int maxProfit2(int prices[]) {
        int length = prices.length;
        if (length == 0)
            return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    // 暴力法，两次遍历，时间复杂度O(n*n)
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - price > maxPrice)
                    maxPrice = prices[j] - price;
            }
        }

        return maxPrice;
    }

}
