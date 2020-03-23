package array;

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
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        IsValidSudoku obj = new IsValidSudoku();

        boolean result = obj.isValidSudoku(nums);

        System.out.println("result:" + result);
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
