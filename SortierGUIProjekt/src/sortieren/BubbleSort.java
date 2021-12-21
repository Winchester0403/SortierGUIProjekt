package sortieren;

import guiProjekt.ArrayPanel;
import guiProjekt.SortierAusgabe;
import util.Util;

import java.util.Arrays;

public class BubbleSort {
    private SortierAusgabe ausgabe;
    public int[] a;

    public BubbleSort(int[] input) {
        a = input;
        this.ausgabe = null;
    }

    public BubbleSort(int[] input, SortierAusgabe ausgabe) {
        a = input;
        this.ausgabe = ausgabe;
        ausgabe.println("BubbleSort gestartet");
    }

    public void sortieren(ArrayPanel panel) {
        // Äußere Schleife, separiert unsortierten von sortiertem Bereich
        if (ausgabe != null) {
            ausgabe.println("Vorher: " + Arrays.toString(a));
        }

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    Util.swap(a, j, j+1);
                    panel.setArray(a);
                }
            }
        }

        if (ausgabe != null) {
            ausgabe.println("Nachher: " + Arrays.toString(a));
        }
    }
}