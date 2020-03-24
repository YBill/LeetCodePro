package array;

import java.util.ArrayList;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 1、数字 1-9 在每一行只能出现一次。
 * 2、数字 1-9 在每一列只能出现一次。
 * 3、数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 这个比较难，做了半天
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] nums = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},

                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},

                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        IsValidSudoku obj = new IsValidSudoku();

        boolean result = obj.isValidSudoku2(nums);

        System.out.println("result:" + result);
    }

    public boolean isValidSudoku2(char[][] board) {
        // 将数独转化为Map，或List，数据多的话Map查找更快，Map中只需要将数独中数存key里就可以，值是啥都不所谓，不过这里最多9个数用啥都可以或写个数组
        // 每一行一个集合，每一列一个集合，每一个块一个集合，分别将数独的三个条件都转化为各自的集合
        ArrayList<Character>[] rows = new ArrayList[9];
        ArrayList<Character>[] columns = new ArrayList[9];
        ArrayList<Character>[] boxes = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new ArrayList<>(9);
            columns[i] = new ArrayList<>(9);
            boxes[i] = new ArrayList<>(9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char data = board[i][j];
                if (data != '.') {
                    if (rows[i].contains(data)) {
                        return false;
                    }
                    rows[i].add(data);

                    if (columns[j].contains(data)) {
                        return false;
                    }
                    columns[j].add(data);

                    // 计算每一个块的下标，这里是按从左到右，从上到下计算下标 0-8
                    // 找规律，i=0,1,2   3,4,5  6,7,8  除3分别算出0,1,2 再乘3就到每行了 加上j/3 再向右偏移
                    // 找规律的时候写出来很容易看出来，实在找不到就 if-else 了
                    int index = i / 3 * 3 + j / 3;
                    if (boxes[index].contains(data)) {
                        return false;
                    }
                    boxes[index].add(data);
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (!isValidSudokuInRow(board)) {
            return false;
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!isValidSudokuInBlock(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidSudokuInRow(char[][] board) {
        for (int k = 0; k < board.length; k++) {
            int startNum = 0;
            int startNumRow = -1;
            int startNumColumn = -1;
            for (int i = 0; i < board[k].length; i++) {
                if (board[k][i] == 46) {
                    for (int j = 0; j < board.length; j++) {
                        if (board[j][i] != 46) {
                            startNum = board[j][i];
                            startNumRow = j;
                            startNumColumn = i;
                            break;
                        }
                    }
                } else {
                    startNum = board[k][i];
                    startNumRow = k;
                    startNumColumn = i;
                }

                if (startNum != 0) {
                    for (int m = startNumRow + 1; m < board.length; m++) {
                        if (board[m][startNumColumn] == startNum) {
                            return false;
                        }
                    }
                    for (int m = startNumColumn + 1; m < board[startNumRow].length; m++) {
                        if (board[startNumRow][m] == startNum) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuInBlock(char[][] board, int row, int column) {
        int[] newBoard = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[index++] = board[row + i][column + j];
            }
        }

        for (int i = 0; i < newBoard.length - 1; i++) {
            for (int j = i + 1; j < newBoard.length; j++) {
                if (newBoard[i] != 46) {
                    if (newBoard[i] == newBoard[j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
