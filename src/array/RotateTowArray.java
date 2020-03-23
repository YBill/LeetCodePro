package array;

import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 必须原地排序（不能开辟额外空间）
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 这个题一看比较复杂，但是是有规律的，规律就是先转置，然后再翻转就得到旋转90的后的矩阵了
 */
public class RotateTowArray {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateTowArray obj = new RotateTowArray();

        obj.rotate(nums);

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;

        // 先转置
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // 再翻转每一列(对应列交换)
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = temp;
            }
        }

    }

}
