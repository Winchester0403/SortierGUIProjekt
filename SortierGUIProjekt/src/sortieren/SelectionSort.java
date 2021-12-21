package sortieren;

import guiProjekt.ArrayPanel;
import guiProjekt.SortierAusgabe;
import util.Util;

import java.util.Arrays;

public class SelectionSort {
    private SortierAusgabe ausgabe;
    public int[] a;

    public SelectionSort(int[] input) {
        a = input;
        this.ausgabe = null;
    }

    public SelectionSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("SelectionSort gestartet");
    }

    public void sortieren(ArrayPanel panel) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich
        if (ausgabe != null) {
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }

        for (int i = 0; i < a.length-1; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            Util.swap(a, i, min);
            panel.setArray(a);
        }

        if (ausgabe != null) {
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}

