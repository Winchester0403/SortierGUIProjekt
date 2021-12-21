package sortieren;

import guiProjekt.ArrayPanel;
import guiProjekt.SortierAusgabe;
import util.Util;

public class MergeSort2 {
    public void sort(int[] elemente) {
        int length = elemente.length;
        int[] sorted = mergeSort(elemente, 0, length - 1);
        // src − This is the source array.
        // srcPos − This is the starting position in the source array.
        // dest − This is the destination array.
        // destPos − This is the starting position in the destination data.
        // length − This is the number of array elements to be copied.
        System.arraycopy(sorted, 0, elemente, 0, length);
    }

    private int[] mergeSort(int[] elemente, int left, int right) {
        if (left == right) return new int[]{elemente[left]};

        int middle = left + (right - left) / 2;
        int[] leftArray = mergeSort(elemente, left, middle);
        int[] rightArray = mergeSort(elemente, middle + 1, right);
        return merge(leftArray, rightArray);
    }

    int[] merge(int[] leftArray, int[] rightArray) {
        int leftL = leftArray.length;
        int rightL = rightArray.length;

        int[] target = new int[leftL + rightL];
        int zielP = 0;
        int leftP = 0;
        int rightP = 0;

        // As long as both arrays contain elements
        while (leftP < leftL && rightP < rightL) {
            int leftValue = leftArray[leftP];
            int rightValue = rightArray[rightP];
            if (leftValue <= rightValue) {
                target[zielP++] = leftValue;
                leftP++;
            } else {
                target[zielP++] = rightValue;
                rightP++;
            }
        }
        // Copy the rest
        while (leftP < leftL) {
            target[zielP++] = leftArray[leftP++];
        }
        while (rightP < rightL) {
            target[zielP++] = rightArray[rightP++];
        }
        return target;
    }
}
