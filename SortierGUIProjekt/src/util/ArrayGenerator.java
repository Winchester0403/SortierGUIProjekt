package util;

public class ArrayGenerator {
    public static int[] randomNumbers(int n, int max) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * max);
        }

        return a;
    }

    // Aufgabe:
    // Überlegen Sie 2 verschiedene Wege
    // wie man Zahlenarrays erzeugen kann
    // die garantiert keine Dopplungen enthalten

    // 1.Weg: (zeitintensiv)
    public static int suche(int[] a, int gesucht) {
        for (int i = 0; i < a.length; i = i + 1) {
            if (a[i] == gesucht) {
                return i;
            }
        }

        return -1;
    }

    public static boolean enthaelt(int[] a, int z) {
        return suche(a, z) >= 0;
    }

    public static int[] keineDopplung1(int n, int max) {
            int[] a = new int[n];
            int zahl;

            if (max >= n) {
                for (int i = 0; i < n; i++) {

                    zahl = (int) (Math.random() * (max + 1));
                    if (enthaelt(a, zahl)) {
                        i--;
                    } else {
                        a[i] = zahl;
                    }
                }
            } else {
                randomNumbers(n, max);
            }

            return a;
    }

    // 2.Weg:
    public static int[] keineDopplung2(int n, int max) {
        int[] a = new int[n];

        if (max >= n) {
            int m = (int) (Math.random() * (max - n + 1) ) + n;
            int minus = 0;
            int q = 0;

            a[n-1] = m;
            for (int i = n-2; i >= 0; i--) {
                q = m/(i+1);
                minus = (int) (Math.random() * q ) + 1;
                a[i] = m - minus;
                m = a[i];
            }
        } else {
            randomNumbers(n, max);
        }

        return a;
    }
}
