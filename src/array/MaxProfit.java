package array;

/**
 * 给定一个数组，输出最大收益，比如给定数组[7,1,5,3,6,4]，最终输出7，7为最大收益，过程如下，
 * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class MaxProfit {

    public static void main(String[] args) {
        int prices[] = {1, 2, 3, 4, 5};

        MaxProfit obj = new MaxProfit();
        int max = obj.maxProfit(prices);

        System.out.println(max);
    }

    /**
     * @param prices
     * @return max
     */
    private int maxProfit(int[] prices) {
        /**
         * 调用 calculate(prices, 0) 是最粗暴的方式，将所有可能都罗列出来算出最大的可能，时间复杂度为O（n的n次幂）。
         * 但是可以找到规律就是最大的值就是依次对相邻两个做差相加的和，所以可以用下面这种简单的方法，时间复杂度为O(1)。
         */
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }

    private int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit)
                        maxProfit = profit;
                }
            }
            if (maxProfit > max)
                max = maxProfit;
        }
        return max;
    }

}
