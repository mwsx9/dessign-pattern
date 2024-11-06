package com.maomaochong.dessign_pattern.nowcoder;

public class TopK {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 7, 9, 8, 3};
        int k = 3;
        if (k <= array.length && k >= 0) {
            System.out.println(findKth(array, array.length, k));
        } else {
            System.out.println("k值错误");
        }
    }

    public static int findKth(int[] array, int n, int k) {
        return findKth(0, n - 1, array, k);
    }

    public static int findKth(int left, int right, int[] array, int k) {
        int m = partation(left, right, array);

        if ((m - left) > (k - 1) && left < right) {
            return findKth(left, m - 1, array, k);
        } else if ((m - left) < (k - 1) && left < right) {
            return findKth(m + 1, right, array, k - m + left - 1);
        } else {
            return array[m];
        }
    }

    public static int partation(int left, int right, int[] array) {
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] <= key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] >= key) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;
    }
}
