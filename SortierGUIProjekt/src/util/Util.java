package util;

public class Util {
    public static void swap(int[] a, int x, int y) {
        int zahl = a[x];
        a[x] = a[y];
        a[y] = zahl;
    }

    public static boolean istStringEineZahl(String input){
        int z = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                z++;
            }
        }

        return z == 0;
    }
}