package sortieren;

import guiProjekt.ArrayPanel;
import guiProjekt.SortierAusgabe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ShakerSort {
    private SortierAusgabe ausgabe;
    public int[] a;
    int k;

    public ShakerSort(int[] input) {
        a = input;
        this.ausgabe = null;
    }

    public ShakerSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("MergeSort gestartet");
    }

    public int[] sort(ArrayPanel panel) {

        int i = 0, l = a.length;
        while (i < l) {
            shaker1(panel, i, l);
            l--;
            shaker2(panel, i, l);
            i++;
        }
        return a;
    }

    private void shaker1(ArrayPanel panel, int i, int l) {
        for (int j = i; j < l - 1; j++) {
            if (a[j] > a[j + 1]) {
                k = a[j];
                a[j] = a[j + 1];
                a[j + 1] = k;
            }
            panel.setArray(a);
        }
    }

    private void shaker2(ArrayPanel panel, int i, int l) {
        for (int j = l - 1; j >= i; j--) {
            if (a[j] > a[j + 1]) {
                k = a[j];
                a[j] = a[j + 1];
                a[j + 1] = k;
            }
            panel.setArray(a);
        }
    }




    public void sortieren(ArrayPanel panel) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich
        if (ausgabe != null) {
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }

        ShakerSort shakerSort = new ShakerSort(a);
        a = shakerSort.sort(panel);

        if (ausgabe != null) {
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}