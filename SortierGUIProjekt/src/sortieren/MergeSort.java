package sortieren;

import guiProjekt.ArrayPanel;
import guiProjekt.SortierAusgabe;
import util.Util;

import java.awt.*;
import java.util.Arrays;

public class MergeSort {
    private SortierAusgabe ausgabe;
    public int[] a;

    public MergeSort(int[] input) {
        a = input;
        this.ausgabe = null;
    }

    public MergeSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("MergeSort gestartet");
    }

    public int[] sort(ArrayPanel panel, int l, int r) {

        if (l < r) {
            int q = (l + r) / 2;

            sort(panel, l, q);
            sort(panel,q + 1, r);
            merge(panel, l, q, r);
        }
        return a;
    }

    private void merge(ArrayPanel panel, int l, int q, int r) {
        int[] arr = new int[a.length];
        int i, j;
        for (i = l; i <= q; i++) {
            arr[i] = a[i];
        }
        for (j = q + 1; j <= r; j++) {
            arr[r + q + 1 - j] = a[j];
        }
        i = l;
        j = r;
        for (int k = l; k <= r; k++) {
            if (arr[i] <= arr[j]) {
                a[k] = arr[i];
                i++;
            } else {
                a[k] = arr[j];
                j--;
            }
            panel.setArray(a);
        }
    }



    public void sortieren(ArrayPanel panel) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich
        if (ausgabe != null) {
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }

        MergeSort ms = new MergeSort(a);
        a = ms.sort(panel,0, a.length - 1);

        if (ausgabe != null) {
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}