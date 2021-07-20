package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class YanghuiTriangle {

    public static void main(String[] args) {
        YanghuiTriangle triangle = new YanghuiTriangle();
        List<List<Integer>> data = triangle.generate(3);
        for (List<Integer> datum : data) {
            for (Integer integer : datum) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(returnList.get(i - 1).get(j - 1) + returnList.get(i - 1).get(j));
                }
            }
            returnList.add(list);
        }
        return returnList;
    }

}
