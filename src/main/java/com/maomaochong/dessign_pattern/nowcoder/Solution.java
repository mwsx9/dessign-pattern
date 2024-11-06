package com.maomaochong.dessign_pattern.nowcoder;

// chuck it up
// 可以练习
// 反馈
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null) {
            return Boolean.FALSE;
        }

        int row = array.length;
        int col = array[0].length;
        if (row == 0 || col == 0){
            return false;
        }

        if (target < array[0][0] || target > array[row - 1][col - 1]) {
            return Boolean.FALSE;
        }

        // 从右上角查起
        int curRow = 0;
        int curCol = col - 1;
        while (curRow < row && curCol >= 0) {
            if (array[curRow][curCol] < target) {
                curRow++;
            } else if (array[curRow][curCol] > target) {
                curCol--;
            } else if (array[curRow][curCol] == target) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }
}
